public class java_50339_CredentialValidator_A07 {    
    private static String[] usernames = {"user1", "admin"};  // Hard-code list of valid username/password pairs         
        
    public void validate(String inputUsername, String password) throws AuthFailureException{     
        boolean isValidUserNameFound=false;    
            for (int i = 0 ;i < usernames.length && !isValidUserNameFound  ; ++i){            
                if ((usernames[i]).equals(inputUsername)){                 //Match username found                  
                    System.out.println("username matched : "+ inputUsername);                 
                                                      isValidUserNameFound=true;                     break;}              else {                                      continue ; }}}}     finally  {}       return null;}}      class AuthFailureException extends Exception{          public    void printStackTrace(){super .printStackTrace(); }}   import java.lang.*;                // Adding this to avoid compilation error