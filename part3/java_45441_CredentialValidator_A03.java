public interface Credential {   // Defining the credential Interface with required functions.
    String getUsername();    
    char[] getPassword();     
}                             
                                 
class java_45441_CredentialValidator_A03 implements Credential{             // Implementing secure credentials using provided methods in our custom Validator class, A03_Injection is prevented here as only the password field can be modified. 
                                                          private String username;             
    @Override                           public char[] getPassword(){   return this.password;}    
                                                                                  if(this.username == null || this.username .isEmpty()){            throw new IllegalArgumentException("Username is either empty or not set");}      else{           password = "Secure Password: ###";    }  // Here we are just returning a hardcoded secure value of 'password'.
                                                           public String getUsername(){ return this.username;}                                if(this.username == null || username .isEmpty()){          throw new IllegalArgumentException("Password is either empty or not set");}       else{                  password = "Secure Password: ###";    }  // Here we are just returning a hardcoded secure value of 'password'.
     private char[] password;                   public SecureCredentials(String username,char [] password){ this.username=username;}             if (this.username == null || this.username .isEmpty() ){          throw new IllegalArgumentException("Username is either empty or not set");} else {                  //password = "Secured Password: ###";   } 
    private char[] getPassword(){ return password;}}               public SecureCredentials(String username,char [] password){ this.username=username;}            if (this.username == null || this.username .isEmpty() ){          throw new IllegalArgumentException("Username is either empty or not set");} else {                  //password = "Secured Password: ###";   }