import java.util.HashMap;
import java.util.Map;

public class java_20511_CredentialValidator_A01 {

    private Map<String, String> credentialMap;

    public java_20511_CredentialValidator_A01() {
        credentialMap = new HashMap<>();
        credentialMap.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (credentialMap.containsKey(username) && credentialMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "password"));  // Outputs: true
        System.out.println(validator.validate("not_admin", "wrong_password"));  // Outputs: false
    }
}