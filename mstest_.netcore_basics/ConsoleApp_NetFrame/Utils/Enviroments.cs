using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp_NetFrame.Utils
{
    class Enviroments
    {
        public static String Enviroment()
        {
            try
            {
                var appSettings = ConfigurationManager.AppSettings;
                string result = appSettings["Ambiente"] ?? "Not Found";
                Console.WriteLine("Env ( " + result + " )");
                return result;
            }
            catch (ConfigurationErrorsException)
            {
                Console.WriteLine("Error reading app settings");
                return null;
            }
        }

    }
}
