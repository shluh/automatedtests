using MSTest_NetCore.Utils;
using System;
using System.Collections.Generic;
using System.Text;

namespace MSTest_NetCore.Workflows
{
    public class PostTest : BaseTestClass
    {
        protected void setUpBeforeTestClass() 
        {
            // no changes needed
            base.setUpBeforeTestClass();
            
        }

        protected void setUpBeforeTestMethod()
        {
            // do the parent actions, then add some post-specific actions
            base.setUpBeforeTestMethod();
            //testPage.goToPostPage();

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
