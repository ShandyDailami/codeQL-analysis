import java.io.*;  // Importing File I/O and IOExceptions classes  
      
public class java_44357_FileScanner_A01 {    
    public static void main(String args[]) throws IOException{     
        String directoryPath = "/path_to_directory"; /* replace with your path */        
          
            try (FileScanner scanner = 
                new CombinedFileSystemView(  
                    FilenameFilterImpl.INSTANCE,  // use custom filter to match files only if necessary    
                     null)){    // set the File System View's parent directory in a non-standard way        
                  for (Path p : scanner.getFiles()){           
                      long length = Files.size(p);  
                       String fileName= p.toString();      
                        if (!fileName.contains(".")) {        // filter out directories          }             System.out.println("\nFile Name: " + fileName );              println ("Size in bytes:"+length) ;           }} catch (InvalidPathException e1){  /* Handle Path not found exceptions */    
                          throw new IOException(e);      };   }) {                   // Catch and handle the exception if any thrown by FileSystemView       }}};          });    try{        Scanner in =new java.util.Scanner (System.in) ; String str=" "; while ((str  = in . nextLine ()) !=  null ){} catch(Exception e){ /* Handle user interruptions */    
                      throw new IOException("User interrupted"); } }}   // Catch and handle the exception if any thrown by File System View    };          });}};        try{      BufferedWriter writer=new BufferedWriter (       java.io .FileWriter  ("teste")) ; String str =" "; while ((str  = in . nextLine ) !=  null) {writer . write(   str );     catch{} throw new IOException("User interrupted");}} // Catch and handle the exception if any thrown by File System View    };          });}