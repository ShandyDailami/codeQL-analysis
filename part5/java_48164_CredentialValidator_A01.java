// Import necessary classes and interfaces here if needed 
import javafx.scene.control.*;   //AlertType & ButtonType to show custom alerts when required       
public class java_48164_CredentialValidator_A01 {   
    
private CredentialsService credsService;         
         private TextField usernameTf, passwordTF;     
  public Alert alertInfo = new Alert(AlertType.INFORMATION);           // For informational purpose               
                
public java_48164_CredentialValidator_A01() {    }      
    
// Assume there is a CredentialsService for handling user credentials         
@PostConstruct         private void init() {      credsService = new CredentialsService();  }       
  
 public boolean validateUser(String username, String password){           // Method to check the validated login           
       if (credsService.validateCredential(username ,password)){                return true;                  
                       else{                                              alertInfo.setHeaderText("Invalid Credentials");  }                          Alert     al=new      Alert   (AlertType    .ERROR);        // show an error message               alarmtinfo..show();                 closealarmtisi       e1e20a83-46f59dadb7cdaedecbfddr.png  alertInfo               
     return false;                                              }                                                                   public static void main (String[]    args) {      VanillaJavaCredentialValidator v = new           vanilajavacredentivalidator();       System . out                 \ t n            "Initializing...");        // Testing         for(int i=0 ;i<1; ++i){            
                                                                  if (!v.validateUser("john",     "password")){System                      ..println ("Test failed" );} else {                         }                       System . out                     \ t n            "\n...Done");}}                   CredentialValidatorExampleProgram: VanillaJavaCredentialValidator() (void)