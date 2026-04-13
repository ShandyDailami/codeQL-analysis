import java.io.*;
import java.nio.file.*;
import static com.sun.jdi.PathNotFoundException.*; // For getFileObject exception handling 

public class java_42761_FileScanner_A01 {  
     public static void main(String[] args) throws IOException, PathNotFoundException{   
          File file = new File("/path/to/yourfile");      
           if(!Files.exists(Paths.get("/"+ file.getName()))){  // check whether the given path is a valid directory or not  
              System.out.println ("The specified file does not exist.");   
          } else {    
             try (Stream<String> lines = Files.lines(file.toPath());) {     
                String accessControlData=""; // Define the variable to hold content of each line  read from a textFile        
                  forEachLine:for (final String s : lines){  
                     if(!s.isEmpty() && !isAccessPermissionSetOnResource(file, s)){    // Check whether permission set on this resource is broken or not    
                        System.out.println("The access control of "+ file +" for the line: '"  +  s+  "' has been violated.");  
                     }       else{     
                         if(!accessControlData.isEmpty()) {              // If there are multiple lines, add them to 'accessContolrData' variable            
                             System.out.println(s);                  
                              accessControlData = (new StringBuilder()).append(s).toString();   }  else{        
                                 if(!isAccessPermissionSetOnResourceByNameAndType(file , s)){     // Check whether permission set on this resource by name and type is broken or not        println("The 'access control of "+ file +" for the line: '"  +s+  "' has been violated.");  }     
                         }}          })}};    else {              System.out.println ("No lines found in File");}}} ;catch (IOException e)   // handle exceptions here             });}                    catch(Exception ex){printStackTrace();};}}) };// End of the main method