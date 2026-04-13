import java.io.*; // Import of Java I/O package which provides File and IOException classes, along with InputStreamReader Class to read the characters from text files in UTF-8 encoding format 
public class java_53782_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    
        String directoryPath = "/path_to/_your__directory"; // Replace it by your path        
           File dir = new File(directoryPath);      
            if (dir.exists() && dir.isDirectory()) {              
                for (File file : dir.listFiles((dir1, name) -> name.endsWith(".txt"))){  
                    // Checking whether the size of a .textfile is more than 5MB or not using 'IntegrityFailure' here...      
                      if(isSizeMoreThanFiveMegabytes(file)){       
                          System.out.println("File: " + file.getName()+" has exceeded maximum size of five megabytes");    
                       } else {        
                           System.out.println("Successfully found a .txt File whose name is : "  +  file.getName());      
                      }}           catch (Exception e){          throw new RuntimeException(e);      // Catching any exception that may occur during the program execution    
             } else {             
                  System.out.println("The directory does not exist or it's a non-directory.");  }   });   `            throws IOException;        }; `