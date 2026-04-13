import java.security.*;
import java.util.*;

public class java_14062_CredentialValidator_A08 {

    private MessageDigest md;

    public java_14062_CredentialValidator_A08() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String passwordAttempt, String correctPassword) {
        byte[] salt = getSalt();
        byte[] hashedAttempt = md.digest(passwordAttempt.getBytes());
        byte[] hashedCorrect = md.digest(correctPassword.getBytes());

        if (Arrays.equals(hashedAttempt, hashedCorrect)) {
            return true;
        } else {
            return false;
        }
    }

    private byte[] getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}