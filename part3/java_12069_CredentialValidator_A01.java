import java.util.Base64;
import java.util.Optional;

public class java_12069_CredentialValidator_A01 {

    // The purpose of this method is to decode a base64 string into a byte array
    private byte[] decodeBase64(String value) {
        return Base64.getDecoder().decode(value);
    }

    // The purpose of this method is to verify if a string matches a certain pattern (e.g., a password)
    private boolean matchesPattern(String value, String pattern) {
        return value.matches(pattern);
    }

    // The purpose of this method is to check if a credential (e.g., a username and password) is valid
    public Optional<String> isValidCredential(String credential, String pattern) {
        String[] parts = credential.split(":");
        if (parts.length != 2) {
            return Optional.empty();
        }
        byte[] decoded = decodeBase64(parts[0]);
        String password = new String(decoded);
        if (!matchesPattern(password, pattern)) {
            return Optional.empty();
        }
        return Optional.of(parts[1]);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String credential = "Y29kaW5nYXlTZWFycHlwYXRjaGFsbGVuZ2VudHJvb3RuZXI=:password123";
        String pattern = "^[a-zA-Z0-9_]{3,}$";
        Optional<String> user = validator.isValidCredential(credential, pattern);
        if (user.isPresent()) {
            System.out.println("User: " + user.get());
        } else {
            System.out.println("Invalid credential");
        }
    }
}