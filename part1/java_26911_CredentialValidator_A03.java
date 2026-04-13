import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;

public class java_26911_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public String getName() {
        return "Custom Validator";
    }

    @Override
    public String validate(String arg0) throws CredentialException {
        // Assuming the password is a valid password
        if (isValidPassword(arg0)) {
            return null;
        } else {
            throw new CredentialException("Invalid password");
        }
    }

    private boolean isValidPassword(String password) {
        try {
            // Check if the password is a valid one
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            return !(new String(digest, "UTF-8").endsWith("$1$"));
        } catch (NoSuchAlgorithmException | java.lang.ExceptionInInitializerException e) {
            e.printStackTrace();
            return false;
        }
    }

}