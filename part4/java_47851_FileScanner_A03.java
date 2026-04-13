import java.io.*; // Importing necessary classes
class java_47851_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{    
        File file = new File(".");// Let's say we are starting from current directory; change it according to your requirement        
       try (FileScanner scanner = 
                new com.sun.nio.fs.UnixFileSystem.Walker()){ // Using Sun NIO for unix like file system operations, remove if you want windows based filesystems  
            List<String> paths = new ArrayList<>();            
               boolean walkUpDirectoryHierarchy =  true;       
                String separator   = File.separatorChar + " "; 
                    scanner .filter(path ->  path !=null && (new File(path).isFile() || (!walkUpDirectoryHierarchy && new File(path  
                    + separator  +"..").isDirectory())) );    // Filtering out directories outside current directory or parent dirs if walkupdirectoryhier  is false.         
            scanner .acceptLinks (true);        /* To follow symbolic links */     
           paths =scanner.paths().toList();   /** to convert file path list into List**/         Scanning the File Hierarchy in Unix like fashion    // If you want unified way then comment out above line and use this one below     scanner .acceptLinks(true);        /* To follow symbolic links */     
            paths.forEach((path) -> System.out.println("Path: " + path));   /** Printing file names **/             });  // Closing the try block              catch (Exception e){e.printStackTrace();}          }