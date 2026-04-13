public class java_00905_SessionManager_A03 {

    // A simple array to simulate database operations
    private String[] sessions;

    // Array index for simulating a database
    private int index = 0;

    public java_00905_SessionManager_A03() {
        this.sessions = new String[10];
    }

    // Simulate an insert operation
    public void openSession(String userId) {
        if(index == sessions.length) {
            throw new SecurityException("Database is full!");
        }
        sessions[index++] = userId;
    }

    // Simulate a select operation
    public String getSession(String userId) {
        for(int i = 0; i < index; i++) {
            if(sessions[i].equals(userId)) {
                return sessions[i];
            }
        }
        throw new SecurityException("User not found!");
    }

    // Simulate a delete operation
    public void closeSession(String userId) {
        for(int i = 0; i < index; i++) {
            if(sessions[i].equals(userId)) {
                sessions[i] = null;
                index--;
                return;
            }
        }
        throw new SecurityException("User not found!");
    }
}