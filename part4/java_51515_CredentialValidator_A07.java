import org.mindrot.jbcrypt.*; // for BcryptHashPassword, BCrypt utility method calls  
                          
public class java_51515_CredentialValidator_A07 {   
     public static boolean validate(String plaintextPwdAttempted, String salt) throws Exception{        
        if (plaintextPwdAttempted == null || salt==null){  //A01_NullInput         
            throw new NullPointerException("Password and Salt cannot be NULL");          
    }   else {            
       boolean passwordMatches = BcryptHashPassword.validate( plaintextPwdAttempted,salt );     
        if (passwordMatches)  return true;         //A02_Match         
              else            throw new AuthenticationFailedException("Invalid Password");     }   catch ( Exception e ) {             System.out.println ("Error: " +e);       return false;}    }}`