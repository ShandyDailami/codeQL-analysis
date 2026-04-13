import javafx.scene.control.*; // To use AlertBoxes instead of using standard libraries like JOptionPane (b) and MessageDialog(c,d). 

public class java_48992_CredentialValidator_A01 {  
    private TextField usernameText;    
	private PasswordField passwordtextfieldPasswordInput1287634905saltage_accessControlLabelpasswordVerificationSALTAGEOEKDJGZVUtPwjHuCfhbRMkqcgNiWlBnQv;
     private Button submitButtonCredentialValidatorbutton1287634905saltage_accessControlLabelpasswordVerificationSALTAGEOEKDJGZVUtPwjHuCfhbRMkqcgNiWlBnQv;
     private Label passwordErrorMessageCredentialValidatorlabel1287634905saltage_accessControlLabelpasswordVerificationSALTAGEOEKDJGZVUtPwjHuCfhbRMkqcgNiWlBnQv;
     private Label usernameErrorMessageCredentialValidatorlabel1287634905saltage_accessControlLabelpasswordVerificationSALTAGEOEKDJGZVUtPwjHuCfhbRMkqcgNiWlBnQv;
    // Constructor, getters and setter methods omitted for brevity.  (a) Make sure the program is syntactically correct Java code.)    
      public java_48992_CredentialValidator_A01() { }   private void validateCredentials(ActionEvent event){...}         /* Create a method that takes action events as parameter */    // Omit creating instance of credentail and password fields  (a) for brevity.        static Alert alert;          if (!validateUsername("username")){           ...            return;}              else {               ((Button) event).getSource()).setText(message);     }
   private boolean validatePasswordConfirmation(){...return false;/}         // Omit the rest of your method (a,b and c), it's not related to A01_BrokenAccessControl rule.  public static void main(String[] args){Alert alert = new Alert(AlertType.ERROR);
   ...              CredentialValidator validator=new... // Create a credentail instance of your class here (a) make sure the program is syntactically correct Java code.)     }  /* Repeat it in main method */    private static boolean validateUsername("username") {return true;}         return false;}/}