import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class java_09048_CredentialValidator_A01 {

    private Map<String, String> users;

    public java_09048_CredentialValidator_A01() {
        this.users = new HashMap<>();
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".split(":")[1].getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("user:user".split(":")[1].getBytes()));
    }

    public boolean validate(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.containsKey(user) && users.get(user).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "admin")); // Output: true
        System.out.println(validator.validate("user", "user")); // Output: true
        System.out.println(validator.validate("admin", "wrong")); // Output: false
    }
}