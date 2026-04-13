import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.ProviderNotFoundException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

public class java_02471_CredentialValidator_A03 {
    private final MessageDigest md;

    public java_02471_CredentialValidator_A03() throws NoSuchAlgorithmException {
        this.md = MessageDigest.getInstance("MD5");
    }

    public boolean isValid(String username, String password) {
        String hashedPassword = this.hashPassword(password);
        return hashedPassword.equals(this.hashPassword(password));
    }

    private String hashPassword(String password) {
        byte[] hashedPasswordBytes = this.md.digest(password.getBytes());
        String hashedPassword = Base64.getEncoder().encodeToString(hashedPasswordBytes);
        return hashedPassword;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, ProviderNotFoundException {
        CredentialValidator validator = new CredentialValidator();
        String username = "user1";
        String password = "password1";
        System.out.println("Is Valid: " + validator.isValid(username, password));
    }
}