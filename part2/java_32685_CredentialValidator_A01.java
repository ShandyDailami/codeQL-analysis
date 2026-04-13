import java.security.InvalidParameterException;

public class java_32685_CredentialValidator_A01 {

    private String defaultPassword;

    public java_32685_CredentialValidator_A01(String defaultPassword) {
        if (defaultPassword == null || defaultPassword.isEmpty()) {
            throw new InvalidParameterException("Default password cannot be null or empty");
        }
        this.defaultPassword = defaultPassword;
    }

    public boolean validate(String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
        return password.equals(this.defaultPassword);
    }
}