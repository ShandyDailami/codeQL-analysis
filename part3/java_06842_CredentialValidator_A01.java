import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.spi.LoginModule;

public class java_06842_CredentialValidator_A01 implements LoginModule {

    private String expectedPassword;

    public java_06842_CredentialValidator_A01(String password) {
        this.expectedPassword = hashPassword(password);
    }

    @Override
    public boolean validate(Subject subject, String password)
            throws CredentialException {
        if (password != null) {
            String passwordToValidate = hashPassword(password);
            return passwordToValidate.equals(expectedPassword);
        } else {
            throw new CredentialException("Password cannot be null");
        }
    }

    private String hashPassword(String password) {
        MessageDigest md;
        String hashedPassword = "";
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }

    @Override
    public boolean getCredentialsExpired(Subject subject) {
        // This method can be used to check if the credentials are expired
        // For this example, we just return false as the credentials are not expired
        return false;
    }

    @Override
    public boolean getEnabled(Subject subject) {
        // This method can be used to check if the account is enabled
        // For this example, we just return true as the account is enabled
        return true;
    }

    @Override
    public Principal getPrincipal(Subject subject) {
        // This method can be used to get the principal object for the current subject
        // For this example, we just return a dummy principal
        return new Principal("user");
    }
}