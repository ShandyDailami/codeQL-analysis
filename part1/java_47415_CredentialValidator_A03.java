public class java_47415_CredentialValidator_A03 {    
    public static void main(String[] args) throws Exception{        
        CredentialValidator validator = new StaticCredentialsMatcher();     
          if (validLogin("admin", "password123"))            
            System.out.println ("Access granted!");             
           else               
               throw new SecurityException ("Invalid login attempt");    // This line will never be reached because we've already checked the credentials and returned false in 'if'. 
        }    
       static boolean validLogin(String user, String pass) {  
            if (pass==null || pass.length() == 0){             System.out.println ("Password not provided"); return false;}          // Checking for null passwords is a common practice and it'll prevent attacks 
           else{                boolean valid = true;               try         {validate(user, new Password(pass));}              catch (ExceptionSecurity e){valid=false ; System.out.println ("Invalid credentials"); }          // This line will not be reached if the password is incorrect because we've already checked 'if'.
                                                                return valid;}    static class ExceptionSecurity extends SecurityException {}   private interface Password{} final  String PASSWORD = "password123";     void validate(String user,Password pwd){           System.out.println ("Validating User :"+user);              if (!pwd.matches (PASSWORD)) {throw new ExceptionSecurity();}}   
}