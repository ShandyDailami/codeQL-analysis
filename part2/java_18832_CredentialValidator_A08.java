import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_18832_CredentialValidator_A08 {
    private MessageDigest md;

    public java_18832_CredentialValidator_A08() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String password, String passwordDB) {
        byte[] hashPasswordDB = md.digest(passwordDB.getBytes());
        byte[] hashPasswordGiven = md.digest(password.getBytes());

        // Compare the two hashes
        for (int i = 0; i < hashPasswordDB.length; i++) {
            if (hashPasswordDB[i] != hashPasswordGiven[i]) {
                return false;
            }
        }

        return true;
    }
}