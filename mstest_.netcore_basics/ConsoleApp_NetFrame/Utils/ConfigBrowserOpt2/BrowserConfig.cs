using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;


namespace ConsoleApp_NetFrame.Utils.ConfigBrowserOpt2
{
    class BrowserConfig
    {
        static IWebDriver driver;

        public static IWebDriver Chrome()
        {
            return driver = new ChromeDriver();
        }


        // Firefox, IE ..
    }
}
