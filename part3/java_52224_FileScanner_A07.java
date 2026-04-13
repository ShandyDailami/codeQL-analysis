import java.io.*; // Import necessary classes for handling File I/O operations, e.g., BufferedReader in combination with InputStreams...  
class java_52224_FileScanner_A07 {    
    public static void main(String[] args) throws IOException  {     
        String pathname = "/path_to_your_directory";                   
         // Open the directory and use a file filter to only look at files (not directories).         
           File folder = new File(pathname);            
            if(!folder.exists()) throw new IllegalArgumentException("Folder does not exist");             
               for (File file : folder.listFiles((dir, name) -> {   // Iterate through each item in the directory   
                 return !file.isDirectory();                   // Only look at files... 
             }))    
                  System.out.println(file);                      // ...and print their names to console         
         }}                           )                         );        })                            };                          });                       `;