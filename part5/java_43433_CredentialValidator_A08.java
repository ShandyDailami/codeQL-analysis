import javafx.util.Pair; // import the Pair class java_43433_CredentialValidator_A08 JavaFX library if not already included in project    
  
public interface CredentialValidator {   
      public boolean validate(String username, String password);      
}                         
                           
class MyCredentials implements CredentialValidator{ 
 private HashMap<Pair<String , Integer>, Boolean>  loginAttempts; // use a Map to store attempts.  
    
public void init() {   
      this.loginAttempts = new HashMap<>();      
}                 
                         public boolean validate(String username , String password){ 
                                 if (this.loginAttempts.containsKey(new Pair<String, Integer>(username , System.currentTimeMillis()))) {    // check the last time this user tried to log in and see it didn't fail before    
                                         long lastTry = this.loginAttempts.get( new  Pair < String,Integer > ( username ,System. currentTime Milli s));     
                                        if (( System .currentTimeMillis() -lasttry)<3000){ //if less than three seconds has passed since the most recent attempt     then return true to continue or false when failure    }  else {   boolean value = loginAttempts.get(username);//retrieve stored data from map
                                 if (value ==true ){ System .out .println ("login success");}else                  //if user failed before, allow access         `return       true;                return false;}            }}         }  else {   this. loginAttempts . put(username ,false);    System out      ". println("welcome back ");    
                         if (password !=null && password == "abc" ){ //check against a hard-coded value for simplicity, in actual case you'd compare hashes of inputted values  }}         }else {   this. loginAttempts . put(username ,true);}} return false;}}}