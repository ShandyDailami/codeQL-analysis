import java.io.*;  // Import File class, InputStreamReader Class etc...  
      
public void scanFileSystem(String rootDir) {    
    try{            
        /* The standard "walk" functionality for file and directory operations */     
           scannableDirectoryProcessingLoop:         while (true){              
                DirectoryStream<File> files = new java.nio.file.Files  // use NIO File API to get Files from a path  
                        .newDirectoryStream(Paths.get(rootDir), "*", RecursiveFileFilter.SHOW_ALL);             
                   for (File file : files) {                      
                     if (!file.isDirectory())                        
                           System.out.println("[Security Sensitive Operation] File:  ->" +   // print the name of each found Files/directory    */                            Paths.get(rootDir).relativize(file.toPath()).toString());                        }                   if (files.iterator().hasNext()) {                    
                         rootDir = file.getAbsoluteFile() .toString();                      break   // Exit loop once parent directory processed,  so continue to next sub-directory or end recursion                    }} catch (IOException e) {}    finally{                                                                            System.out                } ;                                                          };             scanner(root);