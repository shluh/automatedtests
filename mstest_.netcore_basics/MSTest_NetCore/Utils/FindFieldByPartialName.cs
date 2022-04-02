using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace MSTest_NetCore.Utils
{
    public class FindFieldByPartialName
    {
        public static String FilePathName(String directoryInfo, String partialName)
        {

            DirectoryInfo dir = new DirectoryInfo(directoryInfo);
            FileInfo[] filesInDir = dir.GetFiles("*" + partialName + "*.*");
            string fullName = null;

            foreach (FileInfo foundFile in filesInDir)
            {
                fullName = foundFile.FullName;
                Console.WriteLine(fullName);
            }
            return fullName;
        }
    }
}
