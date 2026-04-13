import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_38556_SessionManager_A08 {

    // Hash the user password using SHA-256
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Convert byte array to hexadecimal string
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    // Verify the user password
    public boolean verifyPassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    // Session class
    public class Session {
        private String userId;
        private String userName;

        public java_38556_SessionManager_A08(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        // getters and setters
        public String getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    // User class
    public class User {
        private String username;
        private String password;

        public java_38556_SessionManager_A08(String username, String password) {
            this.username = username;
            this.password = hashPassword(password);
        }

        // getters and setters
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = hashPassword(password);
        }
    }

    // Main class
    public class Main {
        public static void main(String[] args) {
            SessionManager sessionManager = new SessionManager();
            User user = new User("user1", "password");
            Session session = sessionManager.createSession(user);
            System.out.println("User ID: " + session.getUserId());
            System.out.println("User Name: " + session.getUserName());
        }
    }
}