
using Microsoft.Extensions.Configuration;
using System.IO;

namespace MSTest_NetCore.Utils
{
    class JsonConfiguration
    {
        public static IConfigurationRoot Enviroment { get; set; }

        public static void ConfigEnv()
        {
            //var builder = new ConfigurationBuilder()
            //.SetBasePath(Directory.GetCurrentDirectory())
            //.AddJsonFile("environmentsettings.json");
            //Enviroment = builder.Build();

        }
    }
}
