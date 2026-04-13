import java.util.HashMap;
import java.util.Map;

public class java_00038_CredentialValidator_A03 {
    private Map<String, String> users;

    public java_00038_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean isValidCredential(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

public class CredentialValidator {
    private UserManager userManager;

    public java_00038_CredentialValidator_A03(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean validateCredential(String username, String password) {
        return userManager.isValidCredential(username, password);
    }
}

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        CredentialValidator validator = new CredentialValidator(userManager);

        // Usage
        boolean isValid = validator.validateCredential("user1", "password1");
        System.out.println("Is valid: " + isValid);
    }
}