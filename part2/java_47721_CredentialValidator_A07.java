import java.io.*; // Import InputStream and PrintWriter classes specifically (from IOException superclass) 
   import org.apache.commons.io.IOUtils;    // Apache Commons IO library which contains StreamUtils class, I/O utilities functionality required to handle streams of data such as copying byte content from input stream into outputstream or vice-versa in reverse order etc., also provides BufferedInputStream and ByteArrayOutputStream classes
   import javafx.scene.control.*;    // For Alert for error messages displaying 
      
public class java_47721_CredentialValidator_A07 {     
     public boolean validateCredentials(String username, String password) throws IOException{       
          InputStream resourceAsStream = getClass().getResourceAsStream("/usercreds");   // Load a cred file (This is just an example and should be replaced by actual credentials. You can store them in external storage or use database for real-world applications). It'll return the input stream from given classpath location
           if(resourceAsStream == null) {  // If resource not found, then show a dialog with error message         
                Alert alert = new Alert(AlertType.ERROR);  
                alert.setHeaderText("Error");             
                alert.setContentText("Credentials file was not located in the classpath.");   
                               
                ButtonType closeButton=new ButtonType ("OK", ButtonData.OK_DONE);  // Create OK button for dialog                
                                               alerts(alert,closeButton) ;     
                               return false;         }     else {   // Otherwise load credentials from the stream into a string      
                   String fileContent = IOUtils.toString(resourceAsStream,"UTF-8");   
                   String[] credsArray=fileContent.split(":");  // Split it by ":" and check whether username & password match loaded ones           if (credsArray[0].equalsIgnoreCase(username) && credsArray[1].equals(password)) {            return true;         } else{            
                     Alert alert = new Alert(AlertType.ERROR);   // If the credentials do not match, show an error dialog               alerts("Invalid username or password", ButtonType.OK_DONE) ;         
                  try (PrintWriter writer=new PrintWriter ("usercreds")) {  // Save it back to file for next run         }            catch(Exception e){   printStackTrace();}       return false;     }}    public static void alerts(Alert alert,ButtonType closeablebutton)         
               {alert.showAndWait().ifPresent(buttons -> buttons ==closeablebutton);}}  // Show Alert with options and wait for user's choice in a dialog box   }       `catch (Exception e){e .printStackTrace();}         printStackTrace(){}            }}