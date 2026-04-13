import java.io.*; // Import necessary classes into your project: File, IOException etc..  
public class java_52894_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{        
        scanDirectory(".",3);                        
       }     
            private static boolean isTooDeep = false;           // flag to check if the directory depth exceed 2 levels         
            
   /** Scan all files and directories in a given path recursively upto maximum allowed level */     public    static void scanDirectory(String rootPath, int maxDepth) throws IOException {        File dir = new File (rootPath);       // Get file/directory object         if (!dir.exists())  return;
            for (File f : Objects.requireNonNull(dir).listFiles()){      isnull? continue: null ;          switch ((f instanceof DirectoryStream)) ? scanDirectory((String) f, maxDepth-1):null;}           // If it is a directory        {         if (!isTooDeep && (maxDepth <= 0 || !Objects.requireNonNull(dir).getName().equals("target"))){            
                try{System.out.println ("Scanning: " + f);}catch  ((Exception e) => System . out . println ("Failed to scan directory or file :"+f)) ;       // Printing the path of files/ directories           if (maxDepth == 2 ) break;        }
                try{new FileInputStream(Objects.requireNonNull(dir).getAbsolutePath()).close();}catch  ((Exception e) => System . out . println ("Failed to close file: " + f)) ;      // Closing the directory after scanning         }}          private static void scanDirectory (String root, int depth){ if (!root.equals("")){
            try { new FileInputStream(new java.io.File((Objects.requireNonNull(dir).getPath()+"/"  +  dir)) .close();} catch   ((Exception e) => System .. println ("Failed to close directory: " + root ));    // Closing the file after scanning }}}