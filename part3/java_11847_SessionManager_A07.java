public class java_11847_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_11847_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    public void startSession(String sessionId) throws SessionAlreadyExistsException {
        if (sessionMap.containsKey(sessionId)) {
            throw new SessionAlreadyExistsException("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, "Active");
        }
    }

    public void endSession(String sessionId) throws SessionDoesNotExistException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SessionDoesNotExistException("Session does not exist with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, "Inactive");
        }
    }

    public String getSessionState(String sessionId) throws SessionDoesNotExistException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SessionDoesNotExistException("Session does not exist with id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }
}

class SessionAlreadyExistsException extends Exception {
    public java_11847_SessionManager_A07(String message) {
        super(message);
    }
}

class SessionDoesNotExistException extends Exception {
    public java_11847_SessionManager_A07(String message) {
        super(message);
    }
}