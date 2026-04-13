public class java_27792_SessionManager_A07 {
    private static HashMap<String, String> sessionMap;

    public java_27792_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "session1");
    }

    public void checkSession(String username) throws AuthFailure {
        if (!sessionMap.containsKey(username)) {
            throw new AuthFailure("No active session found.");
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
   
    }
}