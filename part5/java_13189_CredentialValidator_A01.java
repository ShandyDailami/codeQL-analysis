import java.util.HashMap;
import java.util.Map;

public class java_13189_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_13189_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password1")); // should print: true
        System.out.println(validator.validate("user1", "wrongpassword")); // should print: false
        System.out.println(validator.validate("unknownuser", "unknownpassword")); // should print: false
    }
}