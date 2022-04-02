using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp_NetFrame.Utils
{
    class BaseClass
    {
        private string URL = Enviroments.Enviroment();

        [SetUp]
        public void setUpBeforeTestClass()
        {
            OpenBrowser();
           
        }

        [TearDown]
        public void tearDownAfterTestClass()
        {
            CloseBrowser();
        }

        public void OpenBrowser()
        {
            Browser.OpenBrowser(BrowsersType.CHROME, URL);
        }
        public void CloseBrowser()
        {
            Browser.CloseBrowser();
        }
    }
}
