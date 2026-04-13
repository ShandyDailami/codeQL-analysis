import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21909_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_21909_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username)) {
            String encodedPassword = credentials.get(username);
            byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
            return password.equals(new String(decodedPassword));
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        String user = "user1";
        String password = "password1";
        System.out.println(validator.validateCredentials(user, password)); // Expected output: true

        user = "user3";
        password = "password3";
        System.out.println(validator.validateCredentials(user, password)); // Expected output: false
    }
}