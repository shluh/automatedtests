using NUnit.Framework;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp_NetFrame.Utils.ConfigBrowserOpt2
{
    class BaseClass
    {
        public IWebDriver driver;

        [SetUp]
        public void setUpBeforeTestClass()
        {
            this.driver = BrowserConfig.Chrome();
            this.driver.Url = Enviroments.Enviroment;
        }

        [TearDown]
        public void tearDownAfterTestClass()
        {
            driver.Close();
            driver.Quit();
        }
    }
}
