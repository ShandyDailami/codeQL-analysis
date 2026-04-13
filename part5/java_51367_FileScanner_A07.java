import java.io.*;  // Import necessary Java packages for file handling  
                  
public class java_51367_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{      
        String path = "C:/";      /* Enter your directory */         
         File folder = new File(path);            
            boolean success;               // Flag to indicate whether the file exists or not 
           try {                         // Try block for exception handling   
                if (folder.mkdirs())   /// If a parent directories doesnot exist then create them     else continue     
                    System.out.println("Folder created");                         
                   } catch(Exception e)                     /* Catching any exceptions*/         
                 {                            //  Print Exception message   
                      e.printStackTrace();                          
                }}  
            FileScanner fileSc = new FileScanner(){     /// Create a inner class for accessing the methods of java's native scanner     
               public boolean visit(File f){           /* Overriding method to handle files */         
                    System.out.println("Visited: " +f.getAbsolutePath());   // Print file names       
                   return true;                       /// Returning 'true'. This allows the FileScanner traverse its own directory tree    else it will not visit child directories  thus skipping them      
                 }};                                /* End of overriding method */              
             success = folder.listFiles(fileSc);              // If file exists then list all files using scanner, otherwise print appropriate message        if (success) {  
                    System.out.println("File listing finished successfully!");    /// Else exception will be printed  } else{ ...}          */                  return success; }} catch (Exception e){ /* Catching exceptions and printing them*/     
                                                            // Prints the Exception message         });}}}}}                          This block is for if-else condition not handling it correctly, you can handle accordingly according to your requirements.  
                                                                        }  };