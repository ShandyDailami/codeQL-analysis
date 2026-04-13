import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class java_27858_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_27858_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(credentials.get(username));
        return password.equals(new String(decodedPassword));
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();

        Set<Map.Entry<String, String>> entrySet = validator.credentials.entrySet();
        for (Map.Entry<?, ?> entry : entrySet) {
            System.out.println("Username: " + entry.getKey() + ", Encoded Password: " + entry.getValue());
        }

        boolean isValid = validator.validateCredentials("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        System.out.println("Is Valid Credentials: " + isValid);
    }
}