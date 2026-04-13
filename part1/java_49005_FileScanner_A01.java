import java.io.*; // Import File and IOException class java_49005_FileScanner_A01 we can throw IOExceptions  
public class Main { 
    public static void main(String[] args) throws Exception{    
        try {     
            String directoryPath = "/path/to/directory";      
             printFilesInDirectoryTreeRecursively("/", new File(directoryPath)); // start with the root folder.  
         } catch (Exception e){         
                System.out.println("An error occurred: " +e);       
            }  finally{    
               try {    if (!fileListPrinted) printAllFilesInFileTree();}      except(Error errMsg){System.err.print("\n Error Message : ");   // Exception handling for the recoverable errors...       System.out.println("Exception Occurred: "+e);}}    
        }    catch (IOException e1 ){         printListFilesInDirectoryTreeRecursively("/",new File(directoryPath));// start with directory path .  throw exception inside a try-catch block to handle exceptions...}   });           System.out.println("");}}}` // End of Main Method