import java.io.*; // Import necessary classes for handling directories and file IOs 
class java_43194_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String baseDir = "/path/to/directory";           // Path to directory with files (Assuming we have access rights here, otherwise replace by your actual path).        
                                                                                                                 
       try (FileScanner scanner = 
                new FileInspector().newInstance(baseDir)) {   // Create a instance of the file inspector.  This is where our security-sensitive operation happens!                   
            while (scanner.hasNext()) {                     // Iterate over all files in directory                       
               String path = scanner.next();              // Get next filename                                                                                     
                               File f= new File(path);   // Instantiate a file object with the current one from our iteration                           
                if (!f.canRead()){                         // Check permissions, not really security-sensitive operation but useful for creating context about what's going on 
                    System.out.println("Warning: "+ path +" is unreadable");  
                   }                               else{                            
                           printFileInfo(path);             // If the file can be read then we know it contains sensitive information and hence, perform security-sensitive operation here           
                }}  finally {                            // Ensure cleanup even if an exception was thrown.    
                    System.out.println("Clean up tasks are done!");   }                   });      catch (Exception ex)               {    throw new RuntimeException(ex);           };                          
        printFileInfo("/path/to//file");                  // Test file operation here, make sure to replace "/directory" with your actual directory path and the specific filename  for testing.     if permission is denied or no such location exists then it will give an exception               }    catch (Exception ex) { throw new RuntimeException(ex); }}