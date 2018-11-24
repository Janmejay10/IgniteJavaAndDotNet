using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Apache.Ignite.Core;

namespace IgniteDotNet
{
    class Program
    {
        static void Main(string[] args)
        {
            Ignition.Start();
            Console.ReadKey(); // to keep the code running
        }
    }
}
