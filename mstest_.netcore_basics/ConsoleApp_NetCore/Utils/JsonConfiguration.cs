
using Microsoft.Extensions.Configuration;
using System;
using System.IO;

namespace ConsoleApp_NetCore.Utils
{
    class JsonConfiguration
    {
        public static IConfigurationRoot Enviroment { get; set; }

        public static void ConfigEnv()
        {
            Console.WriteLine("ENV = " + Directory.GetCurrentDirectory());
            Console.WriteLine("ENV = " + Directory.GetCurrentDirectory());
            Console.WriteLine("ENV = " + Directory.GetCurrentDirectory());
            Console.WriteLine("ENV = " + Directory.GetCurrentDirectory());
            Console.WriteLine("ENV = " + Directory.GetCurrentDirectory());
            Console.ReadLine();
            var builder = new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("config.json");
            Enviroment = builder.Build();
        }
    }
}
