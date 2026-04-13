import java.security.Provider;
import java.security.Security;
import java.util.Base64;

public class java_14757_CredentialValidator_A08 {

    public static void main(String[] args) {

        // Get a list of available security providers
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println("Provider: " + provider.getName());
        }

        // Create a validator
        MyValidator validator = new MyValidator();

        // Validate a user
        validator.validate("user", "password".getBytes());
    }
}

class MyValidator implements java.security.authenticator.Authenticator {

    private byte[] userCredentials;

    @Override
    public byte[] getPassword() {
        return userCredentials;
    }

    @Override
    public boolean getPasswordField(String fieldName, char[] fieldData) {
        return false;
    }

    @Override
    public boolean validate(byte[] password) {
        String decoded = new String(password);
        String[] credentials = decoded.split(":");

        if (credentials.length != 2) {
            System.out.println("Invalid username or password");
            return false;
        }

        String user = credentials[0];
        String pass = credentials[1];

        // Here you can add real logic to check the user against the database or external service.
        // For simplicity, let's just verify the user and password
        if (user.equals("admin") && pass.equals("password")) {
            System.out.println("Credentials Valid");
            return true;
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }
}