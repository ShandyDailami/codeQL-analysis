import java.security.*;   // Import standard Java security classes   
    
public class java_44653_CredentialValidator_A07 {       
      private MessageDigest md;
       public static final String ALGORITHM = "SHA-1";        
         
      public java_44653_CredentialValidator_A07() throws NoSuchAlgorithmException{            
            this.md = MessageDigest.getInstance(ALGORITHM);     }  // Constructor          
  
    private boolean checkPasswordStrength (String password){                
        int length = 0;        
       if (password != null) {         
              byte[] hashBytes = md.digest(password.getBytes());            
            StringBuffer sb = new StringBuffer();                     
                   for (int i= 0 ;i<hashBytes.length ;i++){               // Calculate length of password                       
                       sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));                      }                 
              hashCode = sb.toString();          
         return (length >= 8 && !passwordResetRequested);    // Checking password length and not requested a reset       
      }}            
     public static void main(){          try {                   CredentialValidator credVal =  new  CredentialValidator() ;                System .out .println( "Password strength: +"+credval.checkpassword("Test@1234"));    } catch (NoSuchAlgorithmException e){             
            // Handle exception     }}