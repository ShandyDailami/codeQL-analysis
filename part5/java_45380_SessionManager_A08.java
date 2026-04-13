public enum ValidationResult {PASS(true), WARNING("Warning: you should change the password."), FAILURE("Error: Password does not meet complexity requirements.");
    public final String description;   // Description of result.      
     private boolean success = false;      // Whether or not this is a successful operation 
        ValidationResult(String descr) {description = descr;}         
         }                          
public class java_45380_SessionManager_A08{          
private PasswordEncryptor encrypter =  new BasicPasswordEncryptor();  
                                                  public boolean changeUserPass (byte[] oldPW, byte []newPW){        // Change user password.       String result;  ValidationResult vs = checkNewValidated(oldPW , "Old Password",null); if (!vs) {return false;}    newPasswordVerification =  encrypter .encrypt (String encryptionKey + newPasswort,"UTF-8");  
if(!new password verification){     return fail("Failure: New passWord does not match the old one.", ValidationResult.FAILURE); }  else { result = vs; if(result != PASS)    // If we've reached this point, everything is OK! So change it to a Successful Password Change :
         return success("Password changed successfully",Validation Result .PASS)}      public boolean checkNewValidated (byte []passwordToCheck , String fieldName  null){          if (!userInputValidator.validate(inputFieldValue)) {return false;}   // Check password against complexity requirements           result = vs;     }      
if(!result)    return fail("Error: New Password does not meet the given criteria", ValidationResult .FAILURE); else  SuccessfulPasswordChange  = true}      public boolean changeUserPass (byte[] oldPW, byte []newPw){          // Call method to get user password.      
        String result = "";   if (!result) return false;}     newpasswordVerification =  encrypter .encrypt(String encryptionKey + NewPassword,"UTF-8");      changeUserPass (old PW ,New Password);  }         public static void main {          SecurityManager smanager=new SecurtyMananger();
                byte[] oldPw = new byte[]{1,2};     String passwordToCheck  = "test";    string inputFieldValue=  security manager.encrypter .decrypt(passwordto check,"UTF-8");      if(!securityManager==true) return;  smanager=new SecurtyMananger();
                }        // End of main method}          public interface PasswordEncortor {       String encrpyt (String password, String salt){         ...}}   and implement it: