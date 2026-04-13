import java.io.*;   // Importing the required classes from 'package' stdlib    
import java.nio.file.*; // Using NIO2 FileSystems, Path and BasicFileAttributes class java_44088_FileScanner_A01 class SecureScan {     
        public static void main(String[] args) throws IOException  {      
                String dir = "/path/to/dir";   // path to directory you want scan          
                
               if (args.length != 0){         
                   Path startingPath =  FileSystems.newFileStatus(    
                       Paths.get(args[0]), 8L,   
                        FileAttributeView.newView(null)   // to ignore attributes      
                           ).toAbsolutePath();       
                    if (Files.isDirectory(startingPath)){         
                         Files.walkFileTree     
                             ((DirPath) startingPath -> acceptdir); }           else {  startRoot((file, att)->  files));              }}                void init(){                  // Starts the scan at a directory level               DirEntryHandler         dirH  = new    DIR(pth), ee;            if (ee==null){      System.out.println("Cannot access " + p+ "/" + 
        );}} catch  Exception ex          = ... ;       };     private static void files   // Print out file names and sizes for each found entry         FileEntryHandler fes = new FIL(pth), ee; if (ee==null){          System.out.println("Cannot access " + p+ "/" );} 
        try { Files.walkFileTree((file, att)-> acceptdir); } catch       ...{}}      public static boolean     shouldAccept    // Determines whether a file or directory is to be included in the scan              Boolean   acb = false;         if (ee==null){             System .outprintln("Cannot access "+ p );}
        try {if ((ac) || Files.isReadable(file)){            ... }};}} // If not accepting, then we check for readability of file or directory else skip       return acb;} public static void     main   (){          SecureScan s = new    SS() ;      ......}}}// End the class