import java.util.HashMap;
import java.util.Map;

public class java_18809_CredentialValidator_A07 {
    private Map<String, String> userMap;

    public java_18809_CredentialValidator_A07() {
        userMap = new HashMap<>();
        userMap.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        } else {
            return false;
        }
    }
}

public class User {
    private String username;
    private String password;
    private CredentialValidator validator;

    public java_18809_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
        validator = new CredentialValidator();
    }

    public boolean checkPassword() {
        return validator.validate(username, password);
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "password");
        if (user.checkPassword()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}