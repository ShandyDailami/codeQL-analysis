import java.util.HashMap;
import java.util.Map;

public class java_29642_CredentialValidator_A03 {

    private Map<String, String> credentialMap;

    public java_29642_CredentialValidator_A03() {
        this.credentialMap = new HashMap<>();
        initCredentials();
    }

    private void initCredentials() {
        credentialMap.put("user1", "password1");
        credentialMap.put("user2", "password2");
        credentialMap.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if(credentialMap.containsKey(username) &&
                credentialMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password1")); // should return true
        System.out.println(validator.validate("user1", "wrongPassword")); // should return false
    }

}