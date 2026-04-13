import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_41914_CredentialValidator_A03 {

    private Map<String, String> users = new HashMap<>();

    public java_41914_CredentialValidator_A03() {
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public String validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        if (users.containsKey(username) && users.get(username).equals(encodedPassword)) {
            return "Successfully logged in";
        } else {
            return "Invalid credentials";
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "admin"));
        System.out.println(validator.validate("user", "user"));
    }
}