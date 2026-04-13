import javafx.application.*;
import javafx.scene.control.*;
import javax.security.auth.*;
    
public class java_52348_CredentialValidator_A08 extends Application {  
    public static void main(String[] args) throws Exception{ launch(args); }     
      
    @Override  // Override the start method from JavaFX's App and create a scene with controls for inputting username, password.    
    public void start (Stage primaryStage){  
        Label l = new Label("Username:");           
        TextField uf = new TextField();         // Create fields to take in data from the user     
           FieldValidator validator1 =  e -> {  if(e.getEntity() instanceof UsernamePasswordAuthenticationToken) return true; else throw new ConstraintViolationException("Not a username/password combination"); };  
        l =new Label (" Password: ");            // Create fields to take in data from the user        
       uf= new TextField();             
          FieldValidator validator2 =  e -> {if (e.getEntity() instanceof UsernamePasswordAuthenticationToken) return true; else throw new ConstraintViolationException("Not a username/password combination"); };    // Use lambda expressions for fields to take in data from the user     
        Button b =new  Button ("Login ");       // Create button "login" that is linked with method login         
         BoolPromise promise=b.flatMap(e->     // Method called when click on Login, it will validate credentials and if valid returns true else false   
                e.getGrantedPermissions("user").stream().anyMatch(p ->  p .getPermissionName ().equals ("read") &&  !isAccessAllowed ((UsernamePasswordCredential)e))?      // Checks user has "Read" permission on a resource and if not then returns false else true  
            Promise.fulfilled((Boolean b )->b));     return promise;};    }        });       };});             public static boolean isAccessAllowed (UsernamePasswordCredential cred) {      // Method to check access rights of the user on a resource  if(cred instanceof CredentialsSubject)){return true;}else{throw new UnsupportedOperationException("This feature isn't available in this implementation");}}    return false; }