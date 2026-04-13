import java.io.*;  // Importing File I/O classes for file handling...  
class java_52549_FileScanner_A08 {   
      public static void main(String[] args) throws IOException{    
        String directoryPath = "./";         
        
        File dir = new File(directoryPath);      
            
        if (dir.exists()) {              // Verifying that the specified path exists          
            for (File file : dir.listFiles((Dir, name) -> !name.startsWith("._"))){     // Looping through all files in directory...   
                System.out.println(file);      // ...and printing each one to console....  
                 }       
         } else {                       // If the path does not exist           
             throw new IllegalArgumentException("Invalid file or folder: " + dirPath ); 
     }}          
}