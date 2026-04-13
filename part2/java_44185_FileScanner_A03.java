import java.io.*; // For File I/O classes, utilities etc...   
public class java_44185_FileScanner_A03 {    
      static void fileScan(String path) throws IOException{       
           if (path != null && new File(path).exists()){              
                  File dir = new File(path);               
                 try (DirectoryStream<Path> files =  Files.newDirectoryStream(dir.toPath())) {                  
                        for(Path file :  files)             
                           System.out.println("File: " +file );                     // Prints name of each found file or directory       return;         }           catch(SecurityException se){     
                                                          /*Handle Security Exceptions*/     println("\nAccess denied:\t"+se);   continue;}               try {if (file != null &&  new File(path + "/"  + file).isFile() ){                 // Check if it's a directory         
                                          System.out.println("Directory: " +  path );      return; }              BufferedReader br =null ;                for (;;)           {             try    
                                        (br  = new BufferedReader(new FileReader  (" + file+")))         // Open and read the contents of each        if((line=br.readLine()) !=  null){            System .out   .println("Content in "+  path +  line); }                     catch      IllegalArgumentException       {
                             /*Handle for wrong arguments */           println("\nInvalid Argument: \t"+e ); continue;}                 try     (new FileWriter(file, true)) {}  // No Exceptions here            break; }}              else{ System .out.println("Skipping Non-File or    Directory : " + file); }}}         
      public static void main   (String[] args){        String dirPath = "/home/your_directory";       try {fileScan(dirPath)} catch  (IOException e)           // Exception handling is done here.     println("\nException: \t"+e );} }}