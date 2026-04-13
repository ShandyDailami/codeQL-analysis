import java.util.HashMap;
import java.util.Map;

public class java_02793_CredentialValidator_A03 {

    private Map<String, String> credentialMap;

    public java_02793_CredentialValidator_A03() {
        credentialMap = new HashMap<>();
        credentialMap.put("user1", "password1");
        credentialMap.put("user2", "password2");
        credentialMap.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        return credentialMap.containsKey(username) &&
                credentialMap.get(username).equals(password);
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Validated user1");
        } else {
            System.out.println("Failed to validate user1");
        }

        if (validator.validateCredentials("user4", "password4")) {
            System.out.println("Validated user4");
        } else {
            System.out.println("Failed to validate user4");
        }
    }
}