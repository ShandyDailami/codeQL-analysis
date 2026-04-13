public class java_21765_SessionManager_A08 {
    private StringBuilder sessionIDs;

    public java_21765_SessionManager_A08() {
        this.sessionIDs = new StringBuilder();
    }

    public void startSession() {
        String sessionID = generateSessionID();
        sessionIDs.append(sessionID);
        System.out.println("Started session: " + sessionID);
    }

    public void endSession(String sessionID) {
        sessionIDs.delete(sessionIDs.indexOf(sessionID), sessionIDs.length());
        System.out.println("Ended session: " + sessionID);
    }

    public boolean validateSession(String sessionID) {
        return sessionIDs.toString().contains(sessionID);
    }

    private String generateSessionID() {
        // Simulate the generation of a session ID
        // This should be a secure method of generating a random ID, such as UUID
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sessionID = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = (int) (allowedChars.length() * Math.random());
            sessionID.append(allowedChars.charAt(index));
        }
        return sessionID.toString();
    }
}