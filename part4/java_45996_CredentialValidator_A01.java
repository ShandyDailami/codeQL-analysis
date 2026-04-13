import java.util.*; // for ArrayList etc., List interface  
public class java_45996_CredentialValidator_A01 {   
     private String username;     
     private boolean isAccountActive = false ;      
         public static final LoginAttempt loginAttempts =  new LoginAttempt();         
             @Override              
                 protected void doSomething()  throws IllegalArgumentException,Exception{              System.out . println( " I am doing something");}        }      class CredentialValidator {     private List<String> blackList =new ArrayList<> ();   public boolean validateUserCredentials ( String username , char[] password){         if (!isAccountActive) throw new IllegalArgumentException("This account is not active.");         
                 // add a check to ensure the user has tried too many failed login attempts        return false; }  else {      List<String> recentLoginAttempts =loginAttempts . getRecentAttempts (username);           for(int i=0 ;i <recentLoginAttempts.size();++)        
                 if (!Objects.equals ("password", password)) throw new SecurityException("Incorrect Password");          return false; } else {      // add a check to ensure the username is not in our blacklist            for(String s:blackList){           if (username . equalsIgnoreCase ((s)))thrownewSecurityExceptio n "User has been blocked";}return true;}         }}