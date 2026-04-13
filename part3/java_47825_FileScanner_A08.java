import java.io.*; // Importing File, DirectoryStream etc...
import javax.security.auth.Subject;// For the Subject class - not used in this case but is necessary to call some methods like getPrincipal()..  
                                // Also for SecurityManager interface and its implementations 
                           
public final class java_47825_FileScanner_A08 {    
    private static FileScanner fileScan = new FileScanner();     
       
       public static void main(String[] args) throws Exception{        
           try (DirectoryStream<Path> dirs =  Files.newDirectoryStream(Paths.get("YourTargetDir"))){  // Provide your target directory as a string path here, e.g., "/home/user"         
               for (Path dir : dirs) {            
                   fileScan.readFileAndPrintContentInJsonFormat((dir));   // Reading and printing files content into JSON format        
                }     
            }  catch(SecurityException ex){     // Exception handling due to SecurityManager's operations   
              System.err.println("Access denied: " + dir);      
             }       
          fileScan = null;              
           };  
                 
                 private static class FileScanner{      // This is a helper or utility Class  not part of main method, but as per your request        
                   public void readFileAndPrintContentInJsonFormat(Path dir) throws Exception {            
                        try (Stream<String> lines = Files.lines(dir))    // Reading File Content into Stream   and then convert it to JSON with Jackson Library         
                            {                 
                                ObjectWriter writer= mapper.writerWithDefaultPrettyPrinter();       
                                  for( String line : lines){               
                                       System.out.println("JSON: " + writeValueAsString((Object)line)); // Printing Content as Json           }                      
                               };  
                            ) {    }}                      catch (Exception ex2)};            {}     ;      });                  })                 .build();                   MapperFactory mf = new Mappe  r.Builder().build());               try{ mapr=mf.newMapper(){}}catch(IOException e){e.printStackTrace()};