using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Support.UI;
using System;

namespace ConsoleApp_NetFrame.Utils
{
    public static class Browser
    {
        private static IWebDriver webDriver;
        private static BrowsersType browserType;
        private static String url;

        public static IWebDriver OpenBrowser(BrowsersType browser, String urlPath)
        {
            browserType = browser;
            url = urlPath;
            switch (browser)
            {
                case BrowsersType.FIREFOX:
                    return GetFirefoxDriver();
                case BrowsersType.CHROME:
                    return GetChromeDriver();
                case BrowsersType.IE:
                    return GetIEDriver();

                default:
                    string invalidBrowserMessage = "Browser " + browser + " inexistente ou indisponível.";
                    Console.WriteLine(invalidBrowserMessage);
                    throw new ArgumentException(invalidBrowserMessage);
            }
        }

        private static IWebDriver GetFirefoxDriver()
        {
            FirefoxOptions options = new FirefoxOptions();
            options.AddArgument("--start-maximized");
            return SetWebDriver(new FirefoxDriver(options));
        }

        private static IWebDriver GetChromeDriver()
        {
            ChromeOptions options = new ChromeOptions();
            options.AddArgument("--start-maximized");
            options.AddArgument("--aggressive-cache-discard");
            return SetWebDriver(new ChromeDriver(options));
        }

        private static IWebDriver GetIEDriver()
        {
            return SetWebDriver(new InternetExplorerDriver());
        }

        private static IWebDriver SetWebDriver(IWebDriver driver)
        {
            driver.Manage().Timeouts().PageLoad = TimeSpan.FromSeconds(60);
            driver.Url = url;

            webDriver = driver;
            return webDriver;
        }

        public static void WaitLoadElement(By by)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(webDriver, TimeSpan.FromSeconds(60));
                wait.Until<IWebElement>(d => d.FindElement(by));

            }
            catch (TimeoutException ex)
            {
                Console.Write("Não foi encontrado o elemento mapeado ");
                throw new ArgumentException(ex.Message);
            }
        }

        public static void CloseBrowser()
        {
            webDriver.Quit();
        }
    }
}
