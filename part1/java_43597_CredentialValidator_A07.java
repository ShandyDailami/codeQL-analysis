public class java_43597_CredentialValidator_A07 extends RuntimeException { } //Custom exception to handle auth failure errors 
  
//Our own simple user credentials implementation using a HashMap (this could be replaced by better data storage techniques)     
private Map<String, User> users = new HashMap<>();    
    public void addUser(User u){users.put(u.getUsername(), u);}  //Simplified example of user and password storing  
      
public class CredentialValidator {                      
        private String username;            
            protected PasswordEncoder encoder = new BCryptPasswordEncoder();    
         public void setUserName(String un){username=un;}     
              @Override  //This is where we validate the input credentials against our user database.  
           public boolean authenticate(Credential c) {                  
                try{    User u = users.get(c.getUsername());     if (u==null ) throw new AuthFailureException();      }catch(AuthFailureException e){e.printStackTrace();}  //If user doesn't exist, we generate an error          return false;        
                   catch((SQLException | NoSuchAlgorithmException se) {se.printStackTrace()}){return true;}   for (char[] a : ((PasswordEncoder) encoder).getStrength().buffer()) {} }  //Getting the strength of password and validating it      return false;    
                catch(InvalidKeySpecException i){i.printStackTrace();}    if (!encoder.matches("12345", c.getPassword())) throw new AuthFailureException ();        User u = users.get(c.getUsername());  //Getting the user from database      return encoder.matches ("password" ,u . getPasswd() );    }