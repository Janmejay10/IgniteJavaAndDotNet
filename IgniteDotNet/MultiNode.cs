using Apache.Ignite.Core;
using Apache.Ignite.Core.Cache;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IgniteDotNet
{
    class MultiNode
    {
        static void Main(string[] args)
        {
            IIgnite ignite = Ignition.Start();
            ICache<int, string> cache = ignite.GetOrCreateCache<int, string>("test");
            if (cache.PutIfAbsent(1, "Hello, World!")) //ICache.PutIfAbsent method which guarantees that the cache entry will be created only once.
                Console.WriteLine("Added a value to the cache!");
            else
                Console.WriteLine(cache.Get(1));
            Console.Read();              // Run the program twice
        }
    }
}
