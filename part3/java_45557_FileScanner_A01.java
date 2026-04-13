import javafx.scene.control.*;
import javax.swing.*;
import org.apache.commons.io.*; // Apache Commons IO library for file handling operations, you can use other libraries as well if needed e.g., FileUtils in JDK or others under com.* packages accordingly  
    
public class java_45557_FileScanner_A01 { 
    public static void main(String[] args) throws IOException{          
        String directoryPath = "./src/main"; // You can replace with your path here      
        
        /* Using Apache Commons IO's DirectoryWalk */     
          Files.walk(FileSystems.getDefault().getPath(directoryPath)) 
              .filter(Files::isRegularFile)                     
              .map(files -> files + " is a file")                 // Applying operation on each regular File object in the directory            
              .forEach((fileName)->  {     /* Using JDK's JOptionPane to show message */  
                String content = FileUtils.readFileToString (new File ("src/main/"+ Files.isRegularFile(Files.probeContentType(Paths.get("./" + fileName))).toString()), StandardCharsets.UTF_8);  // Reading and processing each regular text files            
                JOptionPane.showMessageDialog((JFrame)null, content , "Processing File",   JOptionPane.INFORMATION_MESSAGE );          }                   ) ;    };      })           .orElse(System.out::println);  });     // end of filter         */
        }}// End main method; do not remove the comment above and below this line, as they are required by Java's compiler for methods that should be executable code          }   catch (Exception e) { System.err . println(e ); }; finally{ EscapeProcessors }); // Doing post-processing tasks after try/catch block