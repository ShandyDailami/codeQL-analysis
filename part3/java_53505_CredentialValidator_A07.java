import javax.security.auth.*;
import java.rmi.RemoteException;

public class java_53505_CredentialValidator_A07 implements AuthenticationCredentialValidator {
    private static final String USER_DB = "testUser"; // User stored in the database or user table of a relational DB, etc...  (not used here)  
    
        @Override
        public boolean validate(AuthenticationToken arg0){              
            UsernamePasswordToken token=null;             
             if(!arg0.getClass().getName().equals("UsernamePasswordToken")) { // check authentication request type is either username/password or smartcard etc...   (not used here) 
                    System.out.println(new TextMessage ("Unknown Token Type"));         return false;}                else{                  token = ((UsernamePasswordToken )arg0); }               if(!USER_DB .equalsIgnoreCase((String)(token).getID())) { // check the user is in database or not   (not used here)
                    System.out.println(new TextMessage("Authentication Failed"));     return false;                   else{                       String password = new StringBuffer ((String ) token.getPassword()).reverse().toString();              AuthStatus status=null ;  try {status  = SecurityManager .authenticate (token,password ); } catch (@RemoteException e) {}catch(NoSuchAlgorithmException n){}          if(!MySecurityManagerImpl_.getInstance () !=  null && MySecurityManagerIml.INSTANCE_ == this ){              return true;}                  else {System.out.println ("User Authentication failed: " + USERDB);             }return false;}}
     public static void main(String[] args) throws RemoteException, NoSuchAlgorithmException  {}   //main function here... (not used in this example)}                SecurityManager smImpl = new MySecurityManagerIml();               AuthGuard authguard=new AuthenticationQuoterole("user", "admin");             JASPICLIENT cliendstest2014jc;            try {cliendstest20.test ();}catch (@RemoteException e) {} catch(@NoSuchAlgorithm  Exception n){}}