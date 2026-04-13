public class java_47771_CredentialValidator_A07 implements CredentialsMatcher {  
    public boolean doCredentialsMatch(RequestAttributes request, ResponseContext response) throws AuthenticationException { 
        String presentedPassword = new SimplePasswordEncryption().encryptDecryptData(""+request.getParameterMap()["password"]); // You should handle the password correctly before use it here for security reasons  
         if (presentedPassword != null && presentedPassword.equals(new PasswordEnCryption().decryptData())) {  return true; } else{return false;}   
     }     
}         
public class SimplePasswordEncryption implements CredentialsMatcher, Serializable{}       // Use the same serialization as in AuthSuccessHandler