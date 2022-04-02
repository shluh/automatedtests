using System;
using System.Collections.Generic;
using System.Text;

namespace MSTest_NetCore.Utils
{
    class Enviroments
    {
        public static readonly String Enviroment = ReadAllSettings();

        public static String ReadAllSettings()
        {
            JsonConfiguration.ConfigEnv();
            String env = JsonConfiguration.Enviroment["EnvironmentStrings:Env"];

            switch (env)
            {
                case "DEV":
                    env = "";
                    break;

                case "HML":
                    env = "";
                    break;

                case "PRD":
                    env = "";
                    break;
            }

            return env;
        }
    }
}
