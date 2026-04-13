import java.util.HashMap;
import java.util.Map;

public class java_31028_CredentialValidator_A07 {
    private Map<String, String> credentialMap;

    public java_31028_CredentialValidator_A07() {
        credentialMap = new HashMap<>();
        credentialMap.put("user1", "password1");
        credentialMap.put("user2", "password2");
        credentialMap.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (credentialMap.containsKey(username) && credentialMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is valid: " + isValid); // should print true

        isValid = validator.validate("user4", "password4");
        System.out.println("Is valid: " + isValid); // should print false
    }
}