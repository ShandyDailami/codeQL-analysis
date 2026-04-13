import java.io.*; // Importing FileScanner interface and classes 
import java.nio.file.*; // Path class java_43374_FileScanner_A01 in place of older Java NIO based APIs  
// Standard IO operations are not available by default so we need explicit imports for that too, but it'll be removed later on due to space constraints   
    
public final class A01_BrokenAccessControl { 
        public static void main(String[] args) throws IOException{           //Main method where execution starts         
            Path startingPath = FileSystems.getDefault().getRootDirectories()[0].toAbsolutePath();      //Getting the root path of our system   
                                                                                            //A Security Sensitive operation: Scanning a directory for Java files 
             try (FileScanner<Path> scanner =  Dirs.newFileScanner(startingPath, StandardFileAttributes.class)){   // Using java's FileSystem API to get file and directories    
                 while (scanner.hasNext()){   
                     Path next = scanner.next();            
                      if (!Files.isDirectory(next) && Files.toString(next).endsWith(".java")){         // Only files with .class extension are of interest     
                           System.out.println("Found Java file: " + next);         
                       }             
                 }  
            }    catch (Exception ex){                    
                throw new RuntimeException((ex));                  
             };    
        }}  /* Ends main method */