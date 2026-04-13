public class java_49391_SessionManager_A03 {
    private static int counter = 0; // We use this variable as a unique identifier. It increments every time we create another SessionManager instance (i.e., session creation).  
    
    public String id = "session-" + Integer.toString(counter++); 
                                                           
}//End of SecuritySession Class                                            
                                                                       
public class MySecurityContext { // This is a way to manage the security context in Spring style                                 
       private static final ThreadLocal<String> threadLocalUserName =  new ThreadLocal<>();   /* We use this for keeping track user name*/ 
                                                            public void setUser(String username)     {/* Set User Name */       
                                                                    if (username == null || "".equals(username))      return;         else         			threadLocalUserName.set("user");       }            @Override   /* Get the currently logged in user from security context*/ public String getUser()              	{return threadLocalUserName.get();}
                                                                    //We have to implement set and unSet methods as per Spring's concept of Security Context  */     			public void logout () {threadLocalUserName.set(null); }             /* This method is used for setting up the security context when login successful*/	     public String getPrincipal()      	{return "user";}
    //... Implement other methods like setRole, unSetrole etc.. according to Spring's SecurityContext concept   */         			} 
        private static final ThreadLocal<SecuritySession> threadLocal = new ThreadLocal<>(); /* We use this for the session.*/	     public void setSession(SecuritySession securitySession) {threadLocal.set(securitySession);}      @Override      	public SecuritySession getSession()	{return (SecuritySession) threadLocal.get(); }         
        //... Implement other methods like destroy Session, close Method etc.. according to Spring's BeanFactory concept   */	     public void invalidateSession(){threadLocal.set(null);}  /* Logout the user by removing from SecurityContext*/	}//End of MySecurity Context