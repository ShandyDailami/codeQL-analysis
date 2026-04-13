import java.security.InvalidParameterException;

public class java_18407_CredentialValidator_A03 {

    public static interface CredentialValidatorCallback {
        void validate(String username, String password) throws InvalidParameterException;
    }

    private CredentialValidatorCallback callback;
    private String username;
    private String password;

    public java_18407_CredentialValidator_A03(CredentialValidatorCallback callback) {
        this.callback = callback;
    }

    public void validate(String username, String password) throws InvalidParameterException {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        this.username = username;
        this.password = password;

        callback.validate(username, password);
    }

    public static void main(String[] args) {
        CredentialValidatorCallback callback = new CredentialValidatorCallback() {
            public void validate(String username, String password) throws InvalidParameterException {
                if (username.equals("admin") && password.equals("password")) {
                    System.out.println("Access granted");
                } else {
                    throw new InvalidParameterException("Invalid username or password");
                }
            }
        };

        CredentialValidator validator = new CredentialValidator(callback);
        try {
            validator.validate("admin", "password");
        } catch (InvalidParameterException e) {
            System.out.println("Access denied");
        }
    }
}