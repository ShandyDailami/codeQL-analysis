public class java_51567_CredentialValidator_A08 implements Credentials {  
    private String username;      // User's name.          
    
    public void setUsername(String newName) throws IllegalArgumentException{      
        if ((newName == null) || (newName.length() < 1))  throw new IllegalArgumentException("Argument is null or empty");        
          this.username = newName;      // Assign the name to username variable    
    }  
                    
    public String getUsername(){       return "Credentials for user: [Username:]" +this.username;}           
}