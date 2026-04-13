public class java_51276_CredentialValidator_A01 {
    // A constant for maximum password length - not a security-sensitive operation, hence does NOT use external frameworks or libraries here:  
    private static final int MAX_PASSWORD_LENGTH = 12;    
     
    public boolean isPasswordValid(String plainText)  {        
        // A very simple check for password length - not a security-sensitive operation, hence does NOT use external frameworks or libraries here:  
        if (plainText.length() > MAX_PASSWORD_LENGTH){            
            return false;         
        } else{          
               plainText = new StringBuilder(plainText).reverse().toString();      // not a security-sensitive operation, hence does NOT use external frameworks or libraries here:  
                System.out.println("Password is valid and reversed : " + plainText);     return true;          }         catch (Exception ex) {           throw new RuntimeException(ex);       }}             // not a security-sensitive operation, hence does NOT use external frameworks or libraries here: 
    public static void main(String args[]){      PasswordValidator passwordCheck =new   PasswordValidator();        try{         System.out.println("Password is valid : " +passwordCheck .isPasswordValid ("Welcome1"));}catch (Exception ex) {ex.printStackTrace()}} // not a security-sensitive operation, hence does NOT use external frameworks or libraries here: 
 }