import javafx.scene.control.*;   // For AlertBuilder for showing alert messages   
public class java_50639_CredentialValidator_A08 {    
      public static boolean isPasswordStrong(String password) throws Exception{      
            if (password == null){            
                    throw new IllegalArgumentException("Argument cannot be null");        return false;         }         
                //At least 8 characters, at least one uppercase and lower case letter. No special character among them or a digit  
                   String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{7,}$";        return password.matches(pattern);      }       public static void main (String args[]){    try {          
                   if (!isPasswordStrong("password")) throw new Exception();     AlertBuilder  =  //New instance of the alert builder  for showing messages to users in a user-friendly manner, with some default configuration.        MyAlert =new            StandardAlert(MyAlertType.WARNING);        
                            } catch (Exception e){    System .out .println (" Invalid Password");     };       }}