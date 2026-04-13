import java.util.*;   // Used to generate UUIDs and other utilities related operations in JavaSessionManager class java_48328_SessionManager_A01 javax.servlet.*;     // For Servlets API (Not necessary but used here for brevity)         

            

public final class InsecureJavaSessions {  public static HashMap<UUID, String> userSessions = new HashMap<>();   private Object lock;      UUID sessionId ;    UserBean currentUser =  null;     SessionManager(ServletRequest request){         // Constructor       this.request= (HttpServletRequest) request;}

        try{  if((sessionId ==null)) throw new IllegalStateException("Session not found, may be invalidated or expired");   }catch { e1.printStackTrace();}    userSessions =(HashMap<UUID , String> )request .getSession().getAttribute ("user-sessions") ;         lock= request .getSession ().getLock () 

     */ // we must always get the HttpServletRequest instance as session and cannot use other instances        if ((sessionId ==null)) {          throw new IllegalStateException("No valid Session ID");   }    public String createUser(String username, char[] password){         lock.lock(); try{ UserBean temp =new 

     // Users (username);      temp .setpassword((char [] )passwordevent1=null;        return tem‌​pusers ;} catch { e2。printStackexception( ); }finally   lock.unlocK();          /* end of method */

    // Create a new User, if the user already exists or username is taken then do not create another one     public boolean loginUser (String usernamemd , char[] password){         String encryptedpassword ;        Lock .lock() try { encry‌edpassworde=encrypt(password) 

    // md5.generatePasswordEncyption ((char [] ) passowrd); if (!tempusersexcited && ( tempusers ==null || ! tem‌​puserss .equalsIgnoreCase   (username)) { return false; } else{ event1=mdfive eve mdoencrypt(password) ; 

    // md5.verifyPasswordEncryption((char [] ) passowrd,event3 );}} catch {} finally lock..unLock()      /* End of the method */   public String encrpyt (String input){          return ...}     }         private UserBean getLoggedInUser () {             if ((sessionId == null)) throw new IllegalStateException("Not Logge‌ed in"); 

    // Return current user.            try{return(currentuserss) ;        }} catch (IllegalStatemEExceptioN e){e1 .printStackTrace()}; returnnull;}}   public static void main(){         InsecureJavaSessions sessions = new InSec‌ureJavasessionManager();       sessin.createUser("JohnDoe", 'password'); 

     //sessin.loginuser ("johnsmith" ,'passw0rd') ;}   }//end of main method */