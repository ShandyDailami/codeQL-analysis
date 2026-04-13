import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_13770_CredentialValidator_A07 implements CredentialValidator {

    private String storedPassword;

    public java_13770_CredentialValidator_A07() {
        // In a real application, you would normally fetch the password from a secure source
        // This is just for the sake of this example
        this.storedPassword = "password";
    }

    @Override
    public String getCallerName() {
        return "MyCredentialValidator";
    }

    @Override
    public String getId() {
        return "MyCredentialValidator";
   
    }

    @Override
    public String getPassword() {
        return storedPassword;
    }

    @Override
    public boolean validate(CredentialContext credentialContext) throws LoginException {
        // The 'username' in CredentialContext is the name of the user
        // If the user name and password match the ones in the credentials
        // the method returns true
        // Otherwise it returns false
        return credentialContext.getCallerPrincipal().getName().equals(credentialContext.getCredentials())
                && credentialContext.getCallerPrincipal().getPassword().equals(storedPassword);
    }
}