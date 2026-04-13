import java.io.*; // Import necessary classes for File I/O operations  
public class java_48922_FileScanner_A07 {   
     public static void main(String[] args) throws IOException{        
           String directoryPath = "/Users/username";       
           File fileDirectory =  new File (directoryPath);         
             if (!fileDirectory.exists()){               // Checking whether the given path exists or not     
                  System.out.println("The specified folder does not exist");              return;  }      
           else {                      // If directory already present, proceed  
                String[] files = fileDirectory.list();            
                    for (String file : files)                 // Loop through each element in the list of Files    and print them out         
                            System.out.println(file);        }     }}`  **NOTE**: Change '/Users/username' with your own directory path, also note that this code will only work if you have permission to read from provided location (as it is not a security sensitive operation). If the required permissions are denied then an IOException can occur.