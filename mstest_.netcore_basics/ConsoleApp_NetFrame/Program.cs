using System;
using System.IO;
using System.Text;

namespace ConsoleApp_NetFrame
{
    public class Program
    {
        static void Main(string[] args)
        {
            IWebDriver driver = new ChromeDriver();

            //Navigate to google page
            driver.Navigate().GoToUrl("http:www.google.com");

            //Maximize the window
            driver.Manage().Window.Maximize();

            //Find the Search text box using xpath
            IWebElement element = driver.FindElement(By.XPath("//*[@title='Search']"));

            //Enter some text in search text box
            element.SendKeys("learn-automation");

            //Close the browser
            driver.Close();
        }
        }

    }
}

