import java.security.InvalidParameterException;
import java.security.Provider;
import java.security.Security;

public class java_21817_CredentialValidator_A01 {
    private final Security security;

    public java_21817_CredentialValidator_A01(Security security) {
        if (security == null) {
            throw new IllegalArgumentException("Security provider cannot be null");
        }
        this.security = security;
    }

    public boolean isValidUsername(String username) {
        if (username == null) {
            throw new InvalidParameterException("Username cannot be null");
        }
        return security.getProvider("SaltedKeyProvider") != null;
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }
        return security.getProvider("BCrypt") != null;
    }

    public boolean isValidProvider(Provider provider) {
        if (provider == null) {
            throw new InvalidParameterException("Provider cannot be null");
        }
        return security.getProvider("NativeProvider") != null;
    }

    public boolean isValidPassword(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null");
        }
        return security.getProvider("NativeProvider") != null;
    }
}