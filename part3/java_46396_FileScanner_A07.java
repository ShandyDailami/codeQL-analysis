import java.io.*; // Import the necessary libraries
  
public class java_46396_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{      
        String filename = "src\\main//resources";     
          try (FileScanner scanner =  new RudimentaryFileSystem().newScanner()){  // Using rudimentary filesystem for simplicity. You can use external libraries as well  
            System.out.println("Trying to access file: '" + filename +  "'");      
             if(scanner != null) {                                                    
                scanner .initFiles(filename);                                       
                  while (true){  //infinite loop for security sensitive operation                      
                      long mtime = -1;                                               
                        FileInfo info =  scanner.nextFile();                         
                         String path  =info.getPath().toString() ;                   
                           if(!path.equals("")){                                     
                               try {                                                    
                                   Statistics stats  =  Files .getLastModifiedTime( Paths .get (path));  // Accessing file attributes           
                                    mtime =  Math.round ((stats ).lastModified() /1000f);    // millisecond to second     
                                  } catch (IOException e) {                           
                                      System.err.println("Error while reading last modified time " + path );  
                                     continue;                                         
                                   } 
                                if(mtime > -2 ){                                       /* Avoiding authorization failure at mTime =-1 */                     
                                    Files .delete( Paths .get (path));                  // Delete the file after successful operation                    
                                                         System.out.println("File deleted successfully: " + path);   }                                  else {  println ("No changes in File :"+Path ) ;}    break;}}                   catch ((DirectoryIteratorException e)             
                          {}                                                                      finally{System . out . print ( "\nFinished processing files and directories.\n");}}}     if(scanner != null){ scanner.close(); }  // Close the fileScaner, not needed in this example   }}                                           catch (IOException ex ) {            System
                                         ​out​​_.println("Error : " +ex .getMessage());      };                                                                                      });                          /* End of Main */