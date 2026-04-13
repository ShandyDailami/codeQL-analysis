import java.util.HashSet;
import java.util.Set;

public class java_19604_SessionManager_A01 {
    private Set<String> passwords = new HashSet<>();

    public void addPassword(String password) {
        passwords.add(password);
    }

    public boolean isPasswordBroken(String password) {
        return !passwords.contains(password);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        // Add some passwords to the manager
        securityManager.addPassword("hunter2");
        securityManager.addPassword("password");

        // Check if a password is broken
        String brokenPassword = "hunter2";
        if (securityManager.isPasswordBroken(brokenPassword)) {
            System.out.println("Password: " + brokenPassword + " is broken!");
        } else {
            System.out.println("Password: " + brokenPassword + " is not broken!");
        }
    }
}