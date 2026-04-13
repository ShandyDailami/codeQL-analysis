import java.util.HashMap;
import java.util.Map;

public class java_16425_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_16425_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && 
            credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user1", "wrong_password")); // false
        System.out.println(validator.validate("user4", "password4")); // false
    }
}