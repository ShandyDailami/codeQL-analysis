import java.util.HashMap;
import java.util.Map;

public class java_17593_CredentialValidator_A03 {
    private Map<String, String> userMap;

    public java_17593_CredentialValidator_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "$2a$10$EIvN.hqKFt.T9T4uQ3u.uq2v1174.vBWiS.9T2fN.bVS.1ZWiS6"); // hashed password
    }

    public boolean validateCredentials(String user, String password) {
        if (!userMap.containsKey(user)) {
            throw new UserNotFoundException("User not found");
        }
        String hashedPassword = userMap.get(user);
        return BCrypt.checkpw(password, hashedPassword);
    }

    // Custom exception for user not found
    public class UserNotFoundException extends RuntimeException {
        public java_17593_CredentialValidator_A03(String message) {
            super(message);
        }
    }

    // Custom BCrypt hasher
    public static class BCrypt {
        public static boolean checkpw(String password, String hashedPassword) {
            return hashedPassword.equals(BCrypt.hashpw(password, BCrypt.gensalt()));
        }

        public static String hashpw(String password, String salt) {
            return BCrypt.gensalt(10) + password;
        }

        public static String gensalt(int logrounds) {
            return BCrypt.hashpw("some_salt", BCrypt.gensalt(logrounds));
        }
    }
}