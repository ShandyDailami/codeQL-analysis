import javax.security.auth.CredentialProvider;
import javax.security.auth.CredentialProviderResult;
import javax.security.auth.login.LoginException;
import java.util.Base64;

public class java_22952_CredentialValidator_A07 {
    private static class BasicCredentialProvider implements CredentialProvider {
        @Override
        public CredentialProviderResult validate(Credential credential) throws LoginException {
            String userName = credential.getIdentifier();
            String password = new String(credential.getCredentialIdentifier());

            // In a real application, you would need to check the password against a hashed version in your database.
            // Here, we're only checking for the user name and password.

            if (userName != null && userName.equals("admin") && password != null && password.equals("admin")) {
                return new CredentialProviderResult("User is validated", "USER", null);
            } else {
                return new CredentialProviderResult("User is not validated", null, null);
           
            }
        }
    }

    public static void main(String[] args) {
        CredentialProvider provider = new BasicCredentialProvider();
        try {
            Credential credential = provider.validate(new CustomCredential("admin", Base64.getEncoder().encodeToString("admin".getBytes())));
            System.out.println(credential.getStatus());
        } catch (LoginException e) {
            System.out.println("Failed to validate the credential: " + e.getMessage());
        }
    }
}