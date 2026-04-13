import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_00210_CredentialValidator_A01 {

    private String[][] credentials = {
        {"alice", Base64.getEncoder().encodeToString("password1".getBytes())},
        {"bob", Base64.getEncoder().encodeToString("password2".getBytes())},
        {"charlie", Base64.getEncoder().encodeToString("password3".getBytes())}
    };

    public java_00210_CredentialValidator_A01() {}

    public boolean validateCredentials(String username, String password) {
        byte[] bytes = password.getBytes();
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] thedigest = md.digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : thedigest) {
                sb.append(String.format("%02x", b));
            }
            String securePassword = sb.toString();

            for (String[] credential : credentials) {
                if (credential[0].equals(username) && Arrays.equals(md.digest(credential[1].getBytes()), securePassword.getBytes())) {
                    return true;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}