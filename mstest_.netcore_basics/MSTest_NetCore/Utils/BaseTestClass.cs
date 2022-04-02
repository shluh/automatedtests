using System;
using System.Collections.Generic;
using System.Text;

namespace MSTest_NetCore.Utils
{
    public class BaseTestClass 
    {
        protected void setUpBeforeTestClass()
        {
            // initialize a browser driver, connect to servers
        }

        protected void setUpBeforeTestMethod()
        {
            // initialize testPage
            // login to the app, if necessary
        }

        protected void tearDownAfterTestMethod()
        {
            // logout of the app, if necessary
        }

        protected void tearDownAfterTestClass()
        {
            // close connections, close browser as needed
        }
    }
}
