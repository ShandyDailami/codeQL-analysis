import java.nio.file.*;
import java.util.stream.*;
  
public class java_51366_FileScanner_A03 {
    private static final PathMatcher<Path> PATHMATCHER = FileSystems.getDefault().getPathMatcher("glob:**/*");
    
    public void scanDirectory(String dir) throws Exception{  //a function to perform the file scanning  
        Files.walkFileTree(Paths.get(dir), Collections.emptyOptions())                     // Start walking from provided directory                  
          .filter(Files::isRegularFile).forEach((file)-> scanForInjectionAttacks(file));  // Filtering only regular files, and invoke the method to check for injection attacks       
    }    
      
   private void scanForInjectionAttacks (Path file) {                      //a function that checks if a given path contains an attack pattern.                  
      try{                                                                          //try block containing read command with our File object                   
         Files.readAllLines(file).stream().filter(this::isVulnerableToInjectionAttack);  //Read all lines from the file, filter them and run checks for injection attacks            
     } catch (Exception e) {                    	                                       	//catch block with a general exception to handle any error during reading  
       System.out.println("An Error Occurred while scanning: " +file+ ". Message is ->"  +e);  //printing an appropriate message in case of errors   
     }       
      return;                                                                         	//return statement, ending the function after execution                   
   }                     
      
//method to check if a given line contains injection attack patterns. This would be very specific and depend on your application's requirements                     //This is just an example how such method could look like                 
  private boolean isVulnerableToInjectionAttack(String line){         	//check the input for any suspicious characters or sequences that might indicate a vulnerability to injection attacks       return false;      }        });     };   catch (Exception e) { System.out.println("An Error Occurred: " +e);