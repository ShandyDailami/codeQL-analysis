import java.util.HashMap;

public class java_21720_SessionManager_A03 {
    private static SessionManager sessionManager;
    private HashMap<String, User> sessionMap;

    private java_21720_SessionManager_A03(){
        sessionMap = new HashMap<>();
    }

    public static SessionManager getInstance(){
        if(sessionManager == null){
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public User getUser(String sessionId){
        return sessionMap.get(sessionId);
    }

    public void addUserSession(String sessionId, User user){
        sessionMap.put(sessionId, user);
    }

    public void removeUserSession(String sessionId){
        sessionMap.remove(sessionId);
    }
}

class User{
    private String userName;

    public java_21720_SessionManager_A03(String userName) {
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
}