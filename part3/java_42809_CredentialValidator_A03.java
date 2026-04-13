public class java_42809_CredentialValidator_A03 {    
    // Method to validate username and password
    public boolean authenticate(String userName, String passWord) throws Exception{        
        if (userName == null || passWord==null){            
            throw new IllegalArgumentException("User name or Password cannot be empty");             
           }  else {                    
                // Simple check for username and password. In real world scenarios this could use a hash of the entered密码, not plain text   
               if(userName.equalsIgnoreCase("admin") && passWord.equals("pass123")){                  
                  return true;              }  else {            
                // If user name or password is incorrect then throw exception  
                 System.out.println ("Invalid Credentials");          return false;}            }}      public static void main(String[] args) throws Exception         {           String username = "admin";     char [] passwd  = {'1','2', '3'};             // provide your password in this array       new credentialValidator().authenticate (username,passwd);}}