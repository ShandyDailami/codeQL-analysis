import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialException;

public class java_08809_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    public java_08809_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getCallerName() {
        return "UNKNOWN";
    }

    @Override
    public String getName() {
        return "MyCredentialValidator";
    }

    @Override
    public boolean validate(Object credentials) throws CredentialException {
        if (credentials instanceof String) {
            String suppliedCredentials = (String) credentials;

            if (suppliedCredentials.equals(this.username) && suppliedCredentials.equals(this.password)) {
                return true;
            } else {
                throw new CredentialException("Invalid credentials");
            }
        }

        throw new CredentialException("Credentials are not a string");
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            // This will cause a LoginException
            MyCredentialValidator validator = new MyCredentialValidator("username", "password");
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
    }
}