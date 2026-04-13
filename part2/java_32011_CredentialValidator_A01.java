import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32011_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_32011_CredentialValidator_A01() {
        // Create some dummy credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        // Decode the passwords from Base64 and compare
        String encodedPassword = this.credentials.get(user);
        if (encodedPassword == null) {
            System.out.println("Unknown user: " + user);
            return false;
        }

        byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
        String decodedPasswordString = new String(decodedPassword);

        if (decodedPasswordString.equals(password)) {
            System.out.println("Validated user: " + user);
            return true;
        } else {
            System.out.println("Invalid password for user: " + user);
            return false;
        }
    }
}