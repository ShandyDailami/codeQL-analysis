import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.spi.AuthenticationException;

public class java_27871_CredentialValidator_A03 implements javax.security.auth.callback.CallbackHandler, Principal {

    private String username;
    private String password;

    @Override
    public String getName() {
        return username;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws AuthenticationException {
        if (credentials instanceof String) {
            String enteredPassword = (String) credentials;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedPassword = md.digest(enteredPassword.getBytes());

            // In a real application, you would store the hashed password in a database
            // and compare it to the hashed version stored in the database
            // for simplicity, we'll just compare it to the plain text password entered by the user
            if (password.equals(enteredPassword)) {
                this.username = "user"; // Replace with actual user
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getRequestedPrincipal(Principal principal) {
        principal.setName(username);
        return true;
    }

    @Override
    public boolean commit() throws AuthenticationException {
        return true;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.setPassword("hashedPassword"); // Replace with actual hashed password
        // In a real application, you'd want to get the hashed password from the database
        // instead of hardcoding it in the validator

        // In a real application, you would also need a ServletRequest object to
        // obtain the user's credentials, and use the validator to validate them
        // instead of directly comparing the hashed passwords
    }
}