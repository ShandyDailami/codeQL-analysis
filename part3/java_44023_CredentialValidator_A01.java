public class java_44023_CredentialValidator_A01 {    
    public boolean validateCredentials(String username, String password) throws Exception{        
            // Simulate a database connection and check credentials          
             if (isValidUserNameAndPasswordCorrect("admin", "password")) return true; 
              else throw new RuntimeException ("Invalid user name or Password");   
        }     
       private boolean isValidUserNameAndPasswordCorrect(String username, String password){     // This method should be replaced with a real database call to check the credentials.         if (username == "admin" && password=="password") return true; else  throw new RuntimeException ("Invalid user name or Password");   }
        public static void main(String[] args) {     
             CredentialValidator validator = new CredentialValidator();          try{     // This should be wrapped in a real application to catch any exceptions.         if (validator.validateCredentials("admin", "password")) System.out.println ("Access granted"); else  System.err .printlm  
                }catch(Exception e){e. printStackTrace();}}      private class BrokenValidator implements CredentialValidator {     // This demonstrates broken access control, only authorized user can call the method          @Override public boolean validateCredentials (String username , String password) throws Exception{ if ("admin".equalsIgnoreCase
        }  The code above is a skeleton and requires further implementation. As per your request to use standard Java libraries without external frameworks like Spring or Hibernate, I have omitted the details for brevity's sake (unless otherwise specified). However it shows how one might implement such validation in vanilla java given specific constraints of security-sensitive operations related A01_BrokenAccessControl.