import java.io.*; // Import the necessary classes from standard library  
public class java_51842_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{        
        File file = new File("path/to/yourfile");      
          if (file.exists()) 
            System.out.println("\nTotal size of " + file.getName()+" is "  + file.length() /1024);   // Print total filesize in KB    
         else            
           System.out.print("File not found");         
      }   
}