public class java_48275_CredentialValidator_A08 {   // Class definition starts with 'java' 
    private String username;          // Private field for storing the inputted user name    
                                    /* and password - these should be encrypted in real applications */
                                    
                                   public void setUsername(String s) throws Exception{        
                                       if (s == null || s.length() < 5){            throw new IllegalArgumentException("username must not empty nor less than 4 characters"); }          else this.username = s;    // assign the inputted string to username field             }}                   public String getUsername(){ return(this.username);}}