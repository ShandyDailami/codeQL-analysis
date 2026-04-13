import java.io.*; // Import necessary classes from package 
                  // for file processing, IOExceptions and exceptions  
                  
public class java_43386_FileScanner_A03 {                   
    public static void main(String[] args) throws IOException{         
        FileScanner scan = new DirTraversalFileFinder();           
        
       String pathToDirectory;    
 
      if (args.length == 0){               // default directory for file scanning                  
           System.out.println("No arguments provided, using current working dir");                 } else {                  pathToDirectory = args[0];}            
        scanDir(pathToDirectory);                             }}                private static void 扫描目录 (String路径){                      try{                       // Open the directory                     File folder =  new              DirectoryStream.    (" + PATH+ "/*");                   for           ((Entry entry:folder)){               if       (!entry . isDirectory() &&            !(pathToFile =   path  + "/" +  Entry 
         getName).startsWith(".")) {          // only files (not directories) starting with a dot are processed, not the hidden ones                      try      ((InputStreamReader stream =  new FileInputStream    (" + Path+ ")")))     catch       (IOException e){             System.out .println(e);} }}}