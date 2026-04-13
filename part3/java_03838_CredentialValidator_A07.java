import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03838_CredentialValidator_A07 {
    // Static map to hold pre-defined credentials
    private static Map<String, String> credentialMap = new HashMap<>();

    static {
        credentialMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        // Add more users as needed
    }

    public boolean validate(String username, String password) {
        if (credentialMap.containsKey(username)) {
            String encodedPassword = credentialMap.get(username);
            byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
            String decodedPasswordString = new String(decodedPassword);

            return password.equals(decodedPasswordString);
        } else {
            System.out.println("User not found!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("user1", "password1")); // True
        System.out.println(validator.validate("user2", "password2")); // True
        System.out.println(validator.validate("user3", "password3")); // False
    }
}