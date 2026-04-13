import java.util.*;

public class java_10404_SessionManager_A01 {
    // A simple insecure hashmap for demonstration purposes
    private Map<String, String> secureArea;

    public java_10404_SessionManager_A01() {
        secureArea = new HashMap<>();
    }

    public void set(String user, String password) {
        // Hash passwords using SHA-256 in a real application
        // you should use a strong hashing algorithm for security reasons
        String hashedPassword = "hashedPassword"; 
        secureArea.put(user, hashedPassword);
    }

    public String get(String user) {
        // Return the hashed password
        return secureArea.get(user);
    }

    public boolean check(String user, String password) {
        // Verify the password
        String hashedPassword = secureArea.get(user);
        // Again, a real password verification should use a strong hashing algorithm
        // you should use a hashing algorithm with the same algorithm as the hashedPassword
        return hashedPassword.equals(password);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();

        manager.set("Alice", "password");

        boolean accessGranted = manager.check("Alice", "password");
        if (accessGranted) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}