using MSTest_NetCore.Utils;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Data;

namespace MSTest_NetCore.Testcases
{
    [TestFixture]
    public class TestaUtils : BaseClass
    {

        [Test]
        public void XXX()
        {
            string partialName = "Name-";
            string dirToSearch = @"C:\excel\";
            string Path = FindFieldByPartialName.FilePathName(dirToSearch, partialName);

            var dtContent = GetDataTableFromExcelClass.GetDataTableFromExcel(Path);
            Dictionary<string, string> xlsData = new Dictionary<string, string>();

            /*Valida coluna A e coluna B */
            foreach (DataRow dr in dtContent.Rows)
            {
                xlsData.Add(dr["A"].ToString(), dr["B"].ToString());
                
            }
        }
    }
}
