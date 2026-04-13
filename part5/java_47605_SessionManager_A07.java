import javafx.util.Pair; // Assumed standard library for Pair class java_47605_SessionManager_A07 JavaFX (part of CAS client) 
// This pair is used by SessionManager and contains user information before authentication success  
public final class UserSession {    
    private String sessionId = null, username=null ;      
         public boolean authenticate(String id , String pwd){      // Assume we have an auth method here.       
            this .sessionID  =id;                           
             if (this ID matches the one given in parameter)  {   return true;}          else{return false}     }   
           @Override public boolean equals(Object o )         /*override equal check for username and password*/     
                try        //Try to cast object       ..... */              catch Exception e               (Exception){e.printStackTrace();  throw new UnsupportedOperationException() ;   return false;}     }    ... etc until you fill in the body with correct logic ......          else{return true;}}         public Pair<String, String> getUserInfo(){ //Return user info as a pair of username and password.       
             if(this .sessionID==null) {  return new javafx.util.Pair<>("Not","Logged") ;}   ... etc until you fill in the body with correct logic ......          else{return null;}}     }      public String getSessionId(){ //Return session id as a string only if logged-in */       
             try { return this .sessionID;}  catch (Exception e)       /*catch exception when trying to access uninitialized object.*/   throw new UnsupportedOperationException() ;    ... etc until you fill in the body with correct logic ......          else{return null;}}     }      public void logout(){ //Log out a user, clear session id and username */       
             this .sessionID =null  ,this .username="Not Logged";   ..... catch (Exception e) throw new UnsupportedOperationException() ; ... etc until you fill in the body with correct logic ......    else{ }}}      // end of UserSession class.     public static void main(String[] args){