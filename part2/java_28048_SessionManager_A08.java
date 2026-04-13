public class java_28048_SessionManager_A08 {
    private HashMap<String, Session> sessionMap;
    
    public java_28048_SessionManager_A08() {
        sessionMap = new HashMap<String, Session>();
    }
    
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            session = new Session();
            session.setSessionId(sessionId);
            sessionMap.put(sessionId, session);
        }
        return session;
    }
    
    public void closeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            sessionMap.remove(sessionId);
        }
    }
    
    public void invalidateSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.setValid(false);
        }
    }
    
    public void expungeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            sessionMap.remove(sessionId);
        }
    }
}