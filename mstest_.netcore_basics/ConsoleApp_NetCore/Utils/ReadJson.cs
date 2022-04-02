using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp_NetCore.Utils
{
    public class ReadJson
    {

        public static readonly String Enviroment = ReadEnvironment();
        private static String ReadEnvironment()
        {
            JsonConfiguration.ConfigEnv();
            String env = JsonConfiguration.Enviroment["EnvironmentStrings:Env"];

            return env;
        }

    }
}
