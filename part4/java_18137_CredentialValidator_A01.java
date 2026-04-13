import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

public class java_18137_CredentialValidator_A01 implements CredentialValidator {

    private MessageDigest md;

    public java_18137_CredentialValidator_A01() {
        try {
            this.md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validate(Principal arg0, String arg1) {
        // arg0 is the user, arg1 is the password
        // We will hash the password and compare it to the stored hash
        String hashedPassword = getMd5Hex(arg1);

        // Now compare the hashed password with the stored hash
        if (hashedPassword.equals(arg0.getName())) {
            return true;
        } else {
            return false;
        }
    }

    private String getMd5Hex(String input) {
        // Convert input string to MD5
        byte[] hash = md.digest(input.getBytes());
        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}