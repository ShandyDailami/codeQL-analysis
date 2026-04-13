import java.util.Base64;
import java.util.Map;

public class java_08660_CredentialValidator_A01 {
    public boolean validateCredentials(String user, String password) {
        // This is a simple example of a CredentialValidator. In a real-world application,
        // you would typically store the credentials in a secure storage (e.g., a database) and
        // compare them to the provided credentials. In this example, the credentials are stored
        // in a static map and compared directly. In a real-world application, you would also
        // consider other factors such as expiry date, login attempts, etc.
        
        Map<String, String> credentialStore = Map.of(
            "user1", Base64.getEncoder().encodeToString("password1".getBytes()),
            "user2", Base64.getEncoder().encodeToString("password2".getBytes())
        );

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentialStore.containsKey(user) && credentialStore.get(user).equals(encodedPassword);
    }
}