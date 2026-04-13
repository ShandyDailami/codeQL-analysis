public class java_49139_SessionManager_A07 {   // Assuming it's in your AuthService or similar place, you may want to rename accordingly     
    private Map<String, UserSession> sessions = new HashMap<>();  // In-memory store of logged users. You should use a persistent storage like database if possible    

// The below class is only for illustration and it's not secure as any user can create session manually or via code injection  
    public static final String SECURE_SESSION = "secureSession";  // A unique name that will be used to store the Session in a HttpServletRequest. It should also match with logout() method from AuthService    
public class User {      // You might have another object for user if you are using database or other storage  
    public String username;      
}       
  private static final long MAX_INACTIVITY = 10 * 60L;             // Inactivity period is defined as ten minutes. Adjust it according to your needs    
public class UserSession {         
private Date lastActivity = new Date();              public void updateLastActivityTime()   {lastActivity=new Date();}       @PreUpdate private void onPreUpdate(){  this.updateLastActivityTime(); }        // Inactivity period is defined as ten minutes, if session hasn't been updated in the past X time then it should be closed
if (((System.currentTimeMillis() - lastActivity.getTime()) > MAX_INACTIVITY *1000)) { closeSession(SECURE_SESSION); }       // Closes a Session   public static void logout(){      if(!sessions.containsKey("secure")) return; sessions.remove(UserManagerServiceImpl.Secure().getValue()); 
// You need to implement UserStorage, AuthFailureHandler and other necessary parts here         for (String key : request.getSession().getAttributeNames()){     // Removes all Session Attributes if they are not needed       ((HttpServletRequest)request).getSession().removeAttribute(key); }    public void closeSession(){      sessions.remove((SECURE_SESSION));  
}  private static class UserManagerServiceImpl {// You can implement this service to manage the user and provide methods like login() etc here        // Here you should also have a method for logging out which will call Session Manager's logout().    }     if (request.getSession(false) != null){  request.getSession().invalidate();}