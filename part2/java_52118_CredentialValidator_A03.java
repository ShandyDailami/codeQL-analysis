public class java_52118_CredentialValidator_A03 {  
    public boolean validateCredentials(String username, String password) throws Exception{      
        // Avoid using this method in real scenarios. This is only a demonstration of how you can create one without any security measures applied     
         if (username == null || password==null){    
             throw new IllegalArgumentException("Username and Password must be provided");   }    else { 
                try{          // simulate database connection       
                    Thread.sleep(50);       // simulating long-running task          
                     System.out.println("\nSuccessfully logged in as "+username );      return true;    
                 }catch (Exception e){            throw new Exception("Failed to log you out");   }}  if(!validUsernameFormat(username)){throw new IllegalArgumentException ("Invalid username format")} ;    else {if (!checkPasswordStrength(password))         // check password strength        try{          Thread.sleep(50);     System.out.println("\nSuccessfully logged in as "+username );      return true;   }catch (Exception e){throw new Exception ("Failed to log you out");}}}   
  public boolean validUsernameFormat(String username) { // format validation method        if(!Pattern.matches("^[a-zA-Z0-9]{4,16}$",username))         throw   IllegalArgumentException ( "Invalid Username Format" );      return true;     }
  public boolean checkPasswordStrength(String password) { // strength validation method        if(!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,16}$",password)) throw IllegalArgumentException ("Invalid Password Format");       return true;   }
  public static void main (String[] args) throws Exception {      CredentialValidator credVal = new CredentialValidator();         System.out.println(credVal.validateCredentials("admin","Admin@123"));}}