import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31150_CredentialValidator_A03 {

    // A secure way to store credentials (not recommended for real life applications)
    private Map<String, String> credentials = new HashMap<>();

    public java_31150_CredentialValidator_A03() {
        // Hard-coded for simplicity, this should be fetched from some secure source
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean isValid(String user, String password) {
        // Decoding passwords for security reasons, not recommended for real life applications
        String decodedPassword = new String(Base64.getDecoder().decode(credentials.get(user)));

        // Checking if passwords match
        return password.equals(decodedPassword);
    }
}