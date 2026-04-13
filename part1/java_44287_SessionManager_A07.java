public enum AuthFailureReason {LOGIN_FAILURE, LOGOUT_SUCCESSFUL}; // possible reasons of failure.
   public final static AtomicInteger failedLogins = new AtomicInteger(0);// count number log in fail attempts from a single user at the same time . 
public boolean authenticated;          // if it's true, then there was an authentication error and exception message has been set to hold that.      
    public AuthFailureReason failureType=AuthFailureReason.LOGIN_FAILURE ;  	//the reason for login failed ie - wrong password / not found user etc...