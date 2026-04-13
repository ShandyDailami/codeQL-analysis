import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_33717_SessionManager_A07 {
    private static final String SECRET_KEY = "A07_AuthFailure";

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("user1", "pass1");
        sessionManager.accessResource();
        sessionManager.endSession();
    }

    private String createAuthenticationToken(String username, String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(SECRET_KEY.getBytes());
        byte[] bytes = md.digest(username + password);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private void startSession(String username, String password) {
        String token = createAuthenticationToken(username, password);
        System.out.println("Starting session with authentication token: " + token);
    }

    private void accessResource() {
        System.out.println("Attempting to access protected resource...");
        // Simulate a failed attempt for security purposes
        boolean authSuccess = false;
        if (authSuccess) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private void endSession() {
        System.out.println("Ending session...");
    }
}