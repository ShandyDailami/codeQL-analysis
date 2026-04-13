import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
 
public class java_48638_FileScanner_A08 {  
    public static void main(String[] args) throws IOException, InterruptedException{       
         try (Stream<String> lines = Files.lines(Paths.get("passwd"))){             // Read passwd file to get user details           
              while((line=reader.readLine()) !=  null ) {                           // Loop through each line in the 'passwd' 文件         
                  String[] partsOfPasswordFile = line.split(':');                     // Split password data by : character        
                      if(partsOfPasswordFile[1].equals("x")){                         // Check for x as a security sensitive operation     
                          try {                                                        // Attempt to open the file using Paths           
                               Files.copy(Paths.get("/path/to/" + partsOfPasswordFile [0]),        // Copying user's home directory             
                                   new File(".").toPath(), StandardCopyOption.REPLACE_EXISTING);     // If it is successful, overwrite the old file     
                          } catch (IOException e) {                                  // Catch any IOException if thrown            
                              System.out.println(e.getMessage());                     // Print out error message      
                          }                                                                                                          
                      }}  else{ continue;}}                                               	// Continue to next line in case of security failure   
         finally{}  
     }        throw new SecurityException("Secured Operation Failed");                  // Throw exception if operation fails            catch (SecurityException e) { System.out.println(e);}}}                });}