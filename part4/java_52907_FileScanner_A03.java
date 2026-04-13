import java.io.*; // Importing necessary classes 
immutable public class java_52907_FileScanner_A03 {  
    private static final String DIRECTORY = "C:\\pathToDirectory";//provide your path here, replace it with the actual directory in which files are located; provide '..' to go up one level and then a new folder name. For example C:\Users\YourNameFolder  (this is for windows)
    public static void main(String[] args){   //main method starts execution from there    
        File file =new File(DIRECTORY);      
          if (file.exists()) {                    // If the provided directory exists then proceed            
                try{                           // Starting a new thread for each filename in that dir           
                  String content;               /// For storing all contents of files  and being checked against injections   
                        File[] listOfFiles = file.listFiles();   // Getting List Of All Files In This Directory     
                      if (null != listOfFiles) {           // Checking If There Are Any Files At First             
                            for(int i = 0;i<listOfFiles.length ;i++){  /// Looping Through Each File       
                                content = new String(java.nio.file.Files.readAllBytes( listOfFiles[i].toPath() ));   // Reading Content Of Files     
                                  if (content != null && content.contains("SQL Injection")) {    // Checking For SQL injection attack    
                                         System.out.println ("Suspicious activity detected in: " +listOfFiles[i]);  /// Prints File name on Console        
                                     }                                                                      
                                }}catch (Exception e){   // Catch block to handle exceptions, if exception occurs print the error message         
                                    try {    
                                         System.out.println(e);     
                                       } catch (IOException ex) {    // Handle IOExceptions in case of file reading errors            
                                           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);      
                                      }}  
                finally{  /// Always make sure to close the resource after usage    
                  System.out.println("File and its content has been scanned successfully.");      // Success message on console        }}}catch (Exception e){    catch block for handling exceptions if any exception occurs}");}})}}});         }}   };};});  });})))))); }) ;; ); )}))`