//A01_BrokenAccessControl Example

//First, let's define our security context interface. This interface is a context that provides methods to check if a given user is allowed to perform a certain operation.
public interface SecurityContext {
    boolean isUserAllowed(String userName);
}

//Next, let's implement the security context. This context simply checks if the user name is "admin".
public class java_01395_SessionManager_A01 implements SecurityContext {
    public boolean isUserAllowed(String userName) {
        return userName.equals("admin");
    }
}

//Then, let'<｜begin▁of▁sentence｜>s define a session manager interface. This interface provides methods to start a session and to end a session.
public interface SessionManager {
    void startSession(String userName);
    void endSession(String userName);
}

//Next, let's implement a simple session manager. This manager simply keeps track of active sessions.
public class SimpleSessionManager implements SessionManager {
    private Map<String, Boolean> sessionMap = new HashMap<>();

    public void startSession(String userName) {
        sessionMap.put(userName, true);
    }

    public void endSession(String userName) {
        sessionMap.put(userName, false);
    }

    public boolean isSessionActive(String userName) {
        Boolean isActive = sessionMap.get(userName);
        return isActive != null && isActive;
    }
}

//Finally, let's define a service class that uses the session manager and the security context.
public class SecurityService {
    private SecurityContext securityContext;
    private SessionManager sessionManager;

    public java_01395_SessionManager_A01(SecurityContext securityContext, SessionManager sessionManager) {
        this.securityContext = securityContext;
        this.sessionManager = sessionManager;
    }

    public void performOperation(String userName, Runnable operation) {
        if (securityContext.isUserAllowed(userName)) {
            if (sessionManager.isSessionActive(userName)) {
                operation.run();
            } else {
                //The operation cannot be performed because no session is active.
                System.out.println("No active session found for the user.");
            }
        } else {
            //The operation cannot be performed because the user is not allowed.
            System.out.println("Access denied for the user.");
        }
    }
}