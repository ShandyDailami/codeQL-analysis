import java.io.*; // Import FileNotFoundException for file handling (only needed in Java SE)  
       import sun.nio.fs.LinuxFileSystemProvider;// Necessary to use the local filesystem, you should never need it unless there is a bug here on your side 
public class java_51716_FileScanner_A08 {   
     public static void main(String[] args){        // 'main' method begins execution of Java application      
         try{  
             FileScanner("myFile", "passwd:username");//Test file permission and integrity failure for user A08_IntegrityFailure 
              }    catch (Exception e) {            println(e.getMessage());}      // Catch exception if any, otherwise only prints the error message  
         }}     // 'main' method ends execution of Java application          
public class FileScanner{             public static void main() throws Exception  {"          try        {'    ls -l /path/to/{yourfile}' ;               return;}      catch (IOException e) { println ("Cannot execute process"); }   if(!new File(System.getProperty("user.name")+"@" + "localhost").canRead())    
{                  throw new Exception("\"" +  System. getProperty(' user . name')+  "\ "' has no read access on the file /path/to/{yourfile}. Please, check your permissions.");}}                //Testing permission to be able execute ls -l and cat commands  for different users A08_IntegrityFailure