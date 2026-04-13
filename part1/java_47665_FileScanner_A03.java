import javax.activation.FileDataSource;  // Import for java file system utility classes  
import org.apache.commons.io.*;          // Apache Commons IO library used here - avoid direct dependency on spring framework as it's overkill in this case    
public class java_47665_FileScanner_A03 {               
    public static void main(String[] args) throws Exception{ 
        String directoryPath = "/path/to/directory";   // Specify the path of your folder recursively here. For example, /home/* or file://* for unix based systems like Linux and Windows etc as well in case you want to scan entire filesystem use this pattern below: "file:/" + System.getProperty("java.io.tmpdir")
        FileScanner fs = new FileScanner();            // Initializing an instance of the class using default constructor  - not recommended for direct usage but shown here      
         int level = 1;                                // Levels represent folders depth so higher numbers mean deeper folder scans (optional)  
          boolean followSymlinks=false,recursive = true ;// Set to false if you don't want subfolders and files of a parent dir should not be visited but only the content within them.  In case when symlink is used then it will consider as file otherwise directory (optional)   
        fs.scan(directoryPath,level , followSymlinks); // scanning   - recommended usage here with following params: '/path/to/file' or File object and its depth if required      
     } 
      public void scan(String path, int level){            
           try {                     
                 java.io.File dir = new org.apache.commons.io.FileSystemUtils().resolvePath(new String[]{path}).toFile();   // Using Apache Commons IO library to resolve the given string into File object if it is a symbolic link then treat as file else directory  This will work in any JVM but might have different behavior with spring framework because of its dependencies   
                 scanDirectory("", dir, level);                                                       }catch (Exception ex){ex.printStackTrace();}            // Catching and printing exceptions   catch block should be put here for proper exception handling  if you don't want to use try/except then the code will work fine without catching blocks       
     }}