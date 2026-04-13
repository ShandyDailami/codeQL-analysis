import javafx.scene.control.*;  // For Alert, Button...
import org.mindrot.jbcrypt.*;   // Used for password hashing and verification (Bcrypt)
    
public class java_47737_CredentialValidator_A01 {     
    private static TextField usernameInput;       // Input Fields are defined globally as they can't be local variables in the method 
    private static PasswordField pwdInput;        
            
           public void login() throws Exception{              /* Function to log-in */       
               String user = usernameInput.getText();            /** Get Username Input   **/     
               char[] passwordDigest=pwdInput.getText().toCharArray();  // Convert Password into character array     **/   
               
                   if (user == null || user.isEmpty()) {             /* Checking UserName */         
                      Alert alert = new Alert(AlertType.ERROR);       /** Pop up an error message when username is empty **/          
                       alert.setContentText("Please enter your Username");         //Message to be shown in the dialog box  **/     
                     } else if (passwordDigest==null || passwordDigest.length<=0) {     /* Checking Password */             
                      Alert a = new Alert(AlertType.ERROR);                       /** Pop up an error message when Paswword is empty **/         
                        alert.setContentText("Please enter your password");      //Message to be shown in the dialog box  **/    
                    } else if (!validateUserCredentials (user, new String(passwordDigest))) {    /* User Credential Validation */          
                      Alert a = new Alert(AlertType.ERROR);                       /** Pop up an error message when invalid user name or password **/         
                        alert.setContentText("Invalid Username/Password");      //Message to be shown in the dialog box  **/     }        else {   /* If all are correct then show a success Message */      
                          Alert alert = new Alert(AlertType.INFORMATION);            /** Pop up an Success message **/            
                         alert.setContentText("You have logged into system successfully");    //Message to be shown in the dialog box  **/      }        });              /* End of Button Click event */     };               public static void main(String[] args){                  try { Main m = new Main();                 /** Try catch block for exception handling **/                    
                         if (m.login()) System.out.println("User Login Successfully");            //Invoke login method and handle exceptions **/      }catch (Exception e)              /* Catch Exception */             {"+e};   };                  }}  ;;);}