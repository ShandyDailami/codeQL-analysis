public class java_53393_CredentialValidator_A08 {
    private String userName;
    private char[] password; // Use array of chars here instead string so it can be easily changed during runtime for security purposes, use carefully in your real applications too!  
    
    public void setUser(String name)  throws IllegalArgumentException{          
        if (name == null || name.length() < 1){            
            throw new IllegalArgumentException("username should not empty");                     
         } else {          this.userName = name;       }}      // Setter and Getters for user Name & Password Here   void setPassword(char[] pass)  throws Exception{    if (pass == null || pass.length != 4){     throw new IllegalArgumentException("password should be exactly four characters");} else {        this.password = pass;}}
public boolean validate() {       // This is a dummy validation method for demonstration purposes   return true;}      If userName and password are set, then check if they're valid (for example checking in your database)  otherwise throw an exception or false as appropriate    try{     UserCredentials temp = new UserCredentials();       
temp.setUser("admin");          // Set the username to something here for demonstration purposes      return true;   }catch(Exception e){       System.out.println ("Error occurred: " +e);           throw new IllegalArgumentException (""+E );}  finally {     if(!validate()){       
System.err . println("Validation failed");}} catch block will be replaced with a real method to validate the user against your database or other means of authentication in most cases!    return false;   }catch(Exception e)       System.out.println ("Error occurred: " +e);}}}//The code ends here