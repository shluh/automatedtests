using ConsoleApp_NetCore.Utils;
using System;

namespace ConsoleApp_NetCore
{
    public class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Environment ( "+ ReadJson.Enviroment + " )");//ajustar path do json
        }
    }
}
