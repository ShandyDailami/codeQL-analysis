import java.io.*;  // Import the classes needed for FileScanner example (File, Scanner)  
      import javax.imageio.ImageIO;    // If you're using Image as well then these would be necessary too...    
public class java_52663_FileScanner_A03 {          
        public static void main(String[] args){        
            String dirPath = "/path/to/directory";  /* Put your directory path here */     
             try (FileScanner scanner = 
                 new File(".").getAbsoluteFile().listFiles() )     // Create a file-scanning API for the "current" folder.    }                   {                if(file != null)                     System.out . println("\n Scan all files in :  ->\t +dirPath+ \ntype M to move and RM TO REMOVE");  
        // You can use any condition here like whether file is a directory or not, it's either image/text etc..                if(file.isFile()){                 System . out . println (" " +  scanner);                     }                   }}catch (Exception e) {          /* Handle exceptions as needed */                   
                        //System error message and exit the program by calling systemexit();     };}}}}}  For this, you need to replace "/path/to/directory" with your directory path.   Also make sure it's executed in a secure environment for sensitive operations such like file I/O manipulation or even network IO if applicable (i.e., no local files can be accessed)