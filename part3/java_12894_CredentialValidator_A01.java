import java.security.InvalidParameterException;
import java.util.regex.Pattern;

import javax.security.auth.login.CredentialException;
import javax.security.auth.spi.LoginModule;

public class java_12894_CredentialValidator_A01 implements LoginModule {

    private String password;

    @Override
    public void initialize(String parameters, javax.security.auth.AuthenticationContext context)
            throws CredentialException, java.security.SecurityException {
        this.password = parameters;
    }

    @Override
    public boolean authenticate(String password) throws CredentialException {
        this.password = password;

        if (password != null && password.length() >= 10) {
            return true;
        }

        throw new CredentialException("Password must be at least 10 characters long");
    }

    @Override
    public boolean commit() throws CredentialException, java.security.SecurityException {
        return true;
    }

    @Override
    public void lock() {
        // No-op
    }

    @Override
    public void unlock() {
        // No-op
    }

    @Override
    public boolean validate(javax.security.auth.Authentication authentication) {
        // No-op
        return true;
    }

    @Override
    public boolean validate(javax.security.auth.Authentication authentication, java.lang.String role) {
        // No-op
        return true;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        try {
            validator.initialize("myPassword", null);
            if (validator.authenticate("myPassword")) {
                System.out.println("Password is valid");
            } else {
                System.out.println("Password is not valid");
            }
        } catch (CredentialException e) {
            e.printStackTrace();
        }
    }
}