import java.io.*; // Import necessary classes for File I/O operations in your code, e.g., "File", etc...  
public class java_48845_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{      
        String directoryPath = "/path_to_yourDirectory";  /* Replace with actual path */     
        
        File dir = new File(directoryPath);           // Create a file object of the given location, i.e., your folder    
          if (dir.exists()){                         // Check whether this directory exists or not  
            System.out.println("Directory " + dir  +  " exist");      
            
              String[] files = dir.list();         /* This will return an array of all file names in the specified folder */   
               for (int i = 0; i < files.length ;i++) {     // Iterate over these filenames  
                File f = new File(dir,files[i]);       /** Construct a `File` object from our directory and filename  **/       
                 if (!f.canRead()){                    /* Check whether the file can be read */         
                      System.out.println("The permission to access " + files [ i ]  +" is denied");     // If not, then print an error message  
                       continue;                         /** Skip this iteration and move on if we've already printed a warning for another reason **/  }             else {           /* Else it can be read so proceed */            System.out.println("File " + files [ i ]  +" exists with the right permissions");  
                   }}                       // End of inner loop    
              }                     /**End if block**/                         
          }              
         else{                                      // If directory doesn't exist, print an error message    System.out.println("Directory not found: " + dir);  */      /* Replace with the actual path in case where it is a different location and doesnt exists*/       };   /**End if block**/    
        }