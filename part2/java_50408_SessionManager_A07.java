class java_50408_SessionManager_A07 {
    String name; //username, not sensitive data for A07_AuthFailure exercise in this case...
}
  
// SessionManager class without Spring framework usage..
public class AuthSession{ 
     public static User currentUser = null ;     
      
        private boolean isLoggedIn() {         return (currentUser !=null); }    //security-sensitive operation, no external reference to avoid 'A07_AuthFailure'.  
            
          void login(String username){           if (!isSecureOperation("login")){  currentUser = new User();     currentUser.name  =username;}}       public String getLoggedInUsersName(){         return (currentUser==null) ? "Not Logged In" :    //security-sensitive operation, no external reference to avoid 'A07_AuthFailure'.  
                 ((isSecureOperation("getuser"))? currentUser.name: usernameHidingMethod(username));}           private String  usernameHidingMethod (String s){ return "***";}}             public void logout(){         if (!isLoggedIn()) throw new IllegalStateException ("Not Logged In");     //security-sensitive operation, no external reference to avoid 'A07_AuthFailure'.  
                 currentUser = null;}           }// end of AuthSession class.    private methods are not used in this minimalist example..they could be a part if bigger implementation but removed for brevity and security reasons...  public is just because it's more readable than importing them at the top level