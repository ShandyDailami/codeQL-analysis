import java.security.Provider;
import java.security.Security;
import java.util.Base64;

public class java_11902_CredentialValidator_A01 {

    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println("Provider: " + provider.getName());
            System.out.println("Version: " + provider.getVersion());
        }

        String userName = "user";
        String password = "password";

        byte[] decodedPassword = Base64.getDecoder().decode(password);

        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials(userName, decodedPassword);
    }

    public void validateCredentials(String userName, byte[] password) {
        // This is a placeholder. In a real application, you'd want to replace this with a real call to your authentication service.
        // In a mock environment, we'll use a simple comparison.

        String mockUserName = "mockUser";
        byte[] mockPassword = "mockPassword".getBytes();

        if (userName.equals(mockUserName) && Arrays.equals(password, mockPassword)) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}