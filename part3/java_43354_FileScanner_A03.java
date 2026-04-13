import java.io.*; // Import necessary classes for handling files & directories 
class java_43354_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{      
        File file = new File(".");         // Get the current directory               
                
        if (file.canRead())               // Check whether we have read permission on this folder or not            
            findJavaFilesInDirectory(file);      // If yes, call our method to scan it 
    }  
      
     static void findJavaFilesInDirectory(File directory) throws IOException{        
        File[] files = directory.listFiles();          // Get all the file entries in this folder          
                    
            for (int i = 0; i < files.length ;i++){             // Loop through each entry             
                String name=files[i].getName();                  // Store filename into a variable     
                          if(name.endsWith(".java")){                      /* Check whether this file is .Java or not*/ 
                                System.out.println("Found java File: "+ files[i]);             /** If yes, print the name */              }           }}                   )                            );                    }) }; // End of nested for loops and method calls   });}}};});}}}