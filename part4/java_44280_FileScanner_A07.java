import java.io.*; // Import File I/O classes necessary for file handling tasks including finding files, directory management etc...  
public class java_44280_FileScanner_A07 {    
    public static void main(String[] args) throws Exception{     
        String dirPath = "/path_to_directory";  /* Change this to your target path */       //Directory Path        
           File folder = new File(dirPath);         
            if (folder.exists())                      {                    
                for (File file : folder.listFiles()){                 ///List all files in directory, not folders     
                    System.out.println("Name: " +file.getName());  //Print name of each Files  
                        }                           }}                  ;            /*** Closing brackets are necessary here */          };                   /*Closed curly brace is required at the end*/                 });                                                                               );                                                      }) ));                    ** Ending Braces and Parentheses must be closed in this manner for correct syntax. It's a minimalist way of creating Java code using only standard libraries**