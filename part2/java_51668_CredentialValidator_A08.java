public class java_51668_CredentialValidator_A08 implements Authentication {
    private String user; // Hard coded username, should not come from outside world in real application
    private char[] password;//Hard Coded Password also can't go through an external file or source as the scenario is non-security sensitive. 
    
   public java_51668_CredentialValidator_A08(String UserName ,char [] Pwd) { //Constructor for user and pswd, should come from outside world in real application to protect security information (Salt & hash)         
        this.user =UserName;        
       password=Pwd ;     
    } 
    
   @Override public boolean authenticate() {            
           return(this.authenticated()); // Authentication logic here is not included, just verifying if the credentials are valid           
          }       
}//end of class simplecredentials