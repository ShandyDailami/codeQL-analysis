public class java_23347_SessionManager_A01 {
    private String userName;
    private String password;

    public java_23347_SessionManager_A01(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void login() {
        if (isPasswordValid()) {
            System.out.println("Logged in as: " + userName);
        } else {
            System.out.println("Invalid password, unable to log in.");
        }
    }

    private boolean isPasswordValid() {
        // This is a simple mock of a password validation. In a real-world application,
        // a secure way to hash and compare passwords would be used.
        return userName.equals("admin") && password.equals("password");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a session manager for the user "admin" with the password "password".
        SessionManager sessionManager = new SessionManager("admin", "password");

        // Attempt to login.
        sessionManager.login();
    }
}