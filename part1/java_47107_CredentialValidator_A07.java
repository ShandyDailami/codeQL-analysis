public class java_47107_CredentialValidator_A07 {  // replace with your project's name in package-info like this 'com/yourpackage'; etc  
    public static void main(String[] args) {    
        new AuthenticationService().authenticate("securePassword1!", "AuthFailureException");      
    }     
}              
class AuthFailureException extends Exception{  // replace with your project's name in package-info like this 'com/yourpackage'; etc  
public void failedLogin(){     println ("Invalid password - it contains a special character or number.");}}             public class AuthenticationService {    private CredentialValidator validator;      defaut lvlAuthentication(String userName, String Password) throws AuthFailureException{        if (Password == null || !isValidPassword())  throw newAuthFailure in the method. return true;}
private boolean isValidPassword(){     // this could be replaced with your own password validation logic       /*if ((password contains a special character or number))*/ {          validator =new CredentialValidator();      try{           eath(username, Password)} catch (Exception ex){         throw new AuthFailureExceptioN("Invalid credentials");}}