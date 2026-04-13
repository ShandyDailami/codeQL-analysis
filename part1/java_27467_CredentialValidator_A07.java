import java.util.HashMap;

public class java_27467_CredentialValidator_A07 {
    private HashMap<String, String> users;

    public java_27467_CredentialValidator_A07() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = users.get(username);
        if (expectedPassword == null) {
            System.out.println("Invalid username");
            return false;
        }

        if (!expectedPassword.equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        return true;
    }
}