using Apache.Ignite.Core;
using Apache.Ignite.Core.Binary;
using Apache.Ignite.Core.Cache;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IgniteDotNet
{
    class Person1
    {
        public string Name { get; set; }
        public int Age { get; set; }

        public override string ToString()
        {
            return $"Person1 [Name={Name}, Age={Age}]";
        }

        static void Main()
        {
            var cfg = new IgniteConfiguration
            {
                // Register custom class for Ignite serialization
                BinaryConfiguration = new BinaryConfiguration(typeof(Person1))
            };
            IIgnite ignite = Ignition.Start(cfg);

            ICache<int, Person1> cache = ignite.GetOrCreateCache<int, Person1>("persons");
            cache[1] = new Person1 { Name = "Janmejay", Age = 23 };  // Ignite Serialization Part
            cache[2] = new Person1 { Name = "Rudra", Age = 24 };

            foreach (ICacheEntry<int, Person1> cacheEntry in cache)
                Console.WriteLine(cacheEntry);

            var binCache = cache.WithKeepBinary<int, IBinaryObject>();
            IBinaryObject binPerson = binCache[1];                  // Binary Serialization Part
            IBinaryObject binPerson1 = binCache[2];
            Console.WriteLine(binPerson.GetField<string>("Name"));
            Console.WriteLine(binPerson1.GetField<string>("Name")); // getting a paricular field by using the instance of cache
            // in other words -- retrieving a Person object in binary form, and deserialize a single Name field.
            Console.Read();
        }

    }


}
