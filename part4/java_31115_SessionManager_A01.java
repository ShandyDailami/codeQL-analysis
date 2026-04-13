public class java_31115_SessionManager_A01 {
    private String[] users; // Array to hold user names

    public java_31115_SessionManager_A01(String[] users) {
        this.users = users;
    }

    public boolean isUserValid(String user) {
        // Check if user exists in the list
        for (String s : this.users) {
            if (s.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public void accessSystem(String user) throws BrokenAccessControlException {
        if (!isUserValid(user)) {
            throw new BrokenAccessControlException("User is not valid!");
        }
        // Access the system
        System.out.println("Access granted for user: " + user);
    }
}

public class BrokenAccessControlException extends Exception {
    public java_31115_SessionManager_A01(String message) {
        super(message);
    }
}