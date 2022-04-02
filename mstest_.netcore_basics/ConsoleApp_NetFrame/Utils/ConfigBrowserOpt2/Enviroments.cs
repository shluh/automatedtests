using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp_NetFrame.Utils.ConfigBrowserOpt2
{
    class Enviroments
    {
        public static readonly string Enviroment = ReadAllSettings();

        private static String ReadAllSettings()
        {
            var appSettings = ConfigurationManager.AppSettings;
            String env = null;

            foreach (var key in appSettings.AllKeys)
            {
                switch (key)
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
                Console.WriteLine("Key: {0} Value: {1}", key, appSettings[key]);
            }
            if (env != null) return env;
            else return "Error reading app settings";
        }
    }
}
