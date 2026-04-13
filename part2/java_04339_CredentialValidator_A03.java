import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_04339_CredentialValidator_A03 implements LoginModule {

    private String username;
    private String password;

    public java_04339_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Attributes attrs) throws LoginException {
        // No initialization necessary for our module
    }

    @Override
    public Credential validate(Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

            if (usernamePasswordCredential.getIdentifier().equals(this.username) &&
                usernamePasswordCredential.getPassword().equals(this.password)) {
                return new UsernamePasswordCredential(username, password);
            }
        }

        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a CredentialValidator with a custom LoginModule
        CustomLoginModule customLoginModule = new CustomLoginModule("admin", "password");
        CredentialValidator credentialValidator = new CredentialValidator(customLoginModule, null);

        // Use the CredentialValidator to authenticate a user
        UsernamePasswordCredential credential = new UsernamePasswordCredential("admin", "password");
        try {
            credentialValidator.validate(credential);
            System.out.println("Authentication successful!");
        } catch (LoginException e) {
            System.out.println("Authentication failed!");
        }
    }
}