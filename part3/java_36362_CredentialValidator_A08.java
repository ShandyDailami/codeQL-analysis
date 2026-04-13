import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_36362_CredentialValidator_A08 implements CredentialValidationResult, CallbackHandler {

    private String username;
    private char[] password;
    private boolean authenticated;

    public java_36362_CredentialValidator_A08(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException {
        // Here we can use callbackHandler to pass username and password to another class
        // For simplicity, we are just checking if password is correct
        if (checkPassword(this.password)) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return this;
    }

    private boolean checkPassword(char[] password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password);
            byte[] digest = md.digest();

            // Convert it to hexadecimal format
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1, 3));
            }

            String hashPassword = sb.toString();

            // Here you should have a real method to compare hash with a stored password
            // For simplicity, we're comparing with hardcoded password
            return hashPassword.equals("5edcba8f6e85b921");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean committed() {
        return this.authenticated;
    }

    @Override
    public String getCallerPrincipal() {
        return this.username;
    }

    @Override
    public String getUniqueIdentifier() {
        return this.username;
    }
}