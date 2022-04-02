using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace MSTest_NetCore.Utils
{
    public class BrowserConfig
    {
        static IWebDriver driver;

        public static IWebDriver Chrome()
        {
            ChromeOptions options = new ChromeOptions();
            options.AddArgument("start-maximized");

            String FilePath = @"C:\excel";
            CreateAdnCleanFolder(FilePath);
            options.AddUserProfilePreference("download.default_directory", FilePath);
            return driver = new ChromeDriver(".//", options);
        }

        static void CreateAdnCleanFolder(String FilePath)
        {
            if (!Directory.Exists(FilePath)) Directory.CreateDirectory(FilePath);

            System.IO.DirectoryInfo di = new DirectoryInfo(FilePath);
            foreach (FileInfo file in di.GetFiles())
            {
                file.Delete();
            }
        }
        // Firefox, IE ..
    }
}
