import java.io.*;  // Import of File classes and their functionalities   
import static org.apache.commons.lang3.time.DateUtils.*;  
// Apache Commons Lang library is used for date handling functions    
     
public class java_52113_FileScanner_A07 {      
        public void fileSearch(String directoryPath, String extensionToFind) throws IOException  // function to scan a specific type of files   
         {         
            File夹 = new File("C:\\path_to_yourdirectory");  
              if (Folder.isDirectory())               
             {                 
                 System.out.println("\nScanning for file with extension " + 文件扩展名);      // prints out the type of files to be scanned      
                            File[] FilesList = Folder .listFiles(File ->    new   ExtensionFileFilter (extensionToFind));     if ((null != FILES) )                  {          for (final java.io。FilenameEnumeration 文件 enume : file夹的枚举器（files，true))     
                           System .out .println("找到 " + files);             // print out the filename   }                      catch(Exception e){e/堆栈跟踪打印出错误};            }}     protected class ExtensionFileFilter implements FilenameFilter  {          private final String extension; publicExtensionFileFilterextension)
                this.extension=extenstion；}}publicint、equals (Object obj),hashCode()，compareTo(objectobj))   // overrides the methods of Comparable in order to use them with sorting and comparisons         }@Override             public int compareto（AuthFailureFileScanner o) {           return this.extension。 Compare To 这个对象;}}