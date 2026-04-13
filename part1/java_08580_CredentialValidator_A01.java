import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_08580_CredentialValidator_A01 implements CredentialValidator {

    private String storedPassword;

    public java_08580_CredentialValidator_A01(String password) {
        this.storedPassword = this.hashPassword(password);
    }

    @Override
    public String getCallerPrincipal() {
        return "Unknown";
    }

    @Override
    public String getPassword() {
        return this.storedPassword;
    }

    @Override
    public boolean validate(String password) throws LoginException {
        return this.hashPassword(password).equals(this.storedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No MD5 algorithm available. Cannot create password hash.");
        }
    }
}