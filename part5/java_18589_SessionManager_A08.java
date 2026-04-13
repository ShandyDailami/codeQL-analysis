import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_18589_SessionManager_A08 {
    private static String secretKey = "thisIsASecretKey";

    public static String encrypt(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validate(String data) {
        return encrypt(data).equals(encrypt(secretKey));
    }

    public static void main(String[] args) {
        SessionContext context = new SessionContext();

        // Session 1
        context.setSessionId("session1");
        if (context.isValid()) {
            System.out.println("Session 1 is valid");
        } else {
            System.out.println("Session 1 is not valid");
        }

        // Session 2
        context.setSessionId("session2");
        if (context.isValid()) {
            System.out.println("Session 2 is valid");
        } else {
            System.out.println("Session 2 is not valid");
        }

        // Session 3 (This should fail)
        context.setSessionId("session3");
        if (context.isValid()) {
            System.out.println("Session 3 is valid");
        } else {
            System.out.println("Session 3 is not valid");
        }
    }
}