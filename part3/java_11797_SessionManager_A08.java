import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_11797_SessionManager_A08 {

    private String secretKey;

    public java_11797_SessionManager_A08(String secretKey) {
        this.secretKey = secretKey;
    }

    public String generateSessionId(String userId) {
        //Step 1. Generate the userId with the secretKey
        String userIdWithKey = userId + secretKey;

        //Step 2. Convert the userIdWithKey into byte array
        byte[] bytes = userIdWithKey.getBytes();

        //Step 3. Apply SHA-256 encryption algorithm to the byte array
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] thedigest = md.digest(bytes);

        //Step 4. Convert the result into hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < thedigest.length; i++) {
            sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
        }

        //Step 5. Return the session id
        return sb.toString();
    }

    public boolean validateSession(String sessionId, String userId) {
        //Step 1. Again generate the sessionId with the secretKey
        String sessionIdWithKey = sessionId + secretKey;

        //Step 2. Convert the sessionIdWithKey into byte array
        byte[] bytes = sessionIdWithKey.getBytes();

        //Step 3. Apply SHA-256 encryption algorithm to the byte array
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] thedigest = md.digest(bytes);

        //Step 4. Convert the result into hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < thedigest.length; i++) {
            sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
        }

        //Step 5. Return the validation result
        return sb.toString().equals(sessionId);
    }
}