import java.io.*; // Import the necessary Java Libraries to read a file in directory/path  
public class java_52849_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{      
        File folder = new File("C:/Users");  /* Put your Directory path here */     
           if (folder.exists()) {          // Checking whether the given Folder Exists or not  
                for (File file : folder.listFiles()){             // List all files in a directory   
                    System.out.println(file);                   /// Prints out each filename of those listed    
               } 
            } else {                       /* If Directory doesn't exist */        
                 System.out.print("Sorry, there is no such file or folder");   // Display error message     
             }   
        }}`