public class java_13715_CredentialValidator_A07 {
    private String userName;
    private String password;

    public java_13715_CredentialValidator_A07(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean isValid() {
        if (userName == null || password == null) {
            return false;
        }

        if (userName.isEmpty() || password.isEmpty()) {
            return false;
        }

        // This is a very basic validation and should not be used for security
        // sensitive operations. For example, it does not check if the user exists,
        // or if the password is complex enough.
        return true;
    }
}

public class AuthFailureException extends Exception {
    public java_13715_CredentialValidator_A07(String message) {
        super(message);
    }
}

public class AuthenticationService {
    private CredentialValidator credentialValidator;

    public java_13715_CredentialValidator_A07(String userName, String password) {
        this.credentialValidator = new CredentialValidator(userName, password);
    }

    public void authenticate() throws AuthFailureException {
        if (!credentialValidator.isValid()) {
            throw new AuthFailureException("Invalid username or password");
        }

        // Continue with the authentication process
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            AuthenticationService service = new AuthenticationService("user", "password");
            service.authenticate();
        } catch (AuthFailureException e) {
            e.printStackTrace();
        }
    }
}