import java.util.HashMap;
import java.util.Map;

public class java_10091_SessionManager_A01 {
    private Map<String, String> userData = new HashMap<>();

    public java_10091_SessionManager_A01() {
        userData.put("admin", "12345"); // This should be hashed and not stored in plaintext
    }

    public String getPassword(String user) {
        return userData.get(user);
    }

    public boolean isPasswordValid(String user, String password) {
        String hashedPassword = getPassword(user);
        if (hashedPassword == null) {
            return false;
        }

        // This is a simple hash function for demonstration purposes
        // You should use a secure hashing algorithm like bcrypt or Argon2
        return hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // This is a simple hashing function for demonstration purposes
        // You should use a secure hashing algorithm like bcrypt or Argon2
        return String.valueOf(password.hashCode());
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        String adminPassword = securityManager.getPassword("admin");
        boolean isPasswordValid = securityManager.isPasswordValid("admin", adminPassword);

        if (isPasswordValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}