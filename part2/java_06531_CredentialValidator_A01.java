import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_06531_CredentialValidator_A01 {

    private String hashedPassword;

    public java_06531_CredentialValidator_A01(String password) {
        if (password == null || password.length() == 0) {
            throw new InvalidParameterException("Password is required and cannot be null or empty");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            this.hashedPassword = new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String enteredPassword) {
        if (enteredPassword == null || enteredPassword.length() == 0) {
            throw new InvalidParameterException("Entered password is required and cannot be null or empty");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] enteredPasswordHash = md.digest(enteredPassword.getBytes());

            return this.hashedPassword.equals(new String(enteredPasswordHash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}