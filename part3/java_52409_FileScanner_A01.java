import java.io.*; // Importing necessary classes such as BufferedReader, FileInputStream etc..  
public class java_52409_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{       
            String directoryPath = "/path/to";// replace with your own path here; 
            
           if (args.length == 0){ // check for command line argument or not provided, then default to current work dir        
               System.out.println("Scanning Current Work Directory");  
                directoryPath=new File(".").getCanonicalFile().getPath();    } 
             try(FileSystem fs = FileSystems.newFileSystem(Paths.get(directoryPath), null)){      // creating a file system      
                  Files.walkFileTree(fs.getRoot(), new SimpleFileVisitor<Path>(){   // starting the walk from root directory    
                      @Override    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{ 
                            if (file.toString().endsWith(".txt")) {        super.visitFile(file,attrs);          System.out.println("Scanning a .TXT FILE - Security Sensitive operation");      }    return FileVisitResult.CONTINUE;   }} ){}       catch 
                  // (SecurityException e) {}     finally{           ...        };}             });         if there are other files, they will be scanned too as well in the same way          and it does not stop until all file types have been checked for A01_BrokenAccessControl issue.    }}