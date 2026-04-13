import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;

public class java_38528_SessionManager_A03 {
    private String secretKey;

    public java_38528_SessionManager_A03(String secretKey) {
        this.secretKey = secretKey;
    }

    public String createSession(String userId) throws NoSuchAlgorithmException, NoSuchProviderException {
        // Combine userId and secretKey
        String input = userId + secretKey;

        // Use the SHA-256 algorithm to generate a hash of the input
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(input.getBytes());

        // Convert the hash to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xFF & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public boolean validateSession(String sessionId, String userId) throws NoSuchAlgorithmException, NoSuchProviderException {
        // Combine userId and secretKey
        String input = userId + secretKey;

        // Use the same algorithm as in createSession()
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(input.getBytes());

        // Convert the hash to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xFF & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        // Compare the hash of the sessionId with the hash of the userId
        return sessionId.equals(hexString.toString());
    }
}