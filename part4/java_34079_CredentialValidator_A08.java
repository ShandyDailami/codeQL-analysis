import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class java_34079_CredentialValidator_A08 {

    private final Map<String, String> userMap;
    private final Function<String, String> hasher;

    public java_34079_CredentialValidator_A08(String[] usernames, String[] passwords) {
        this.userMap = new HashMap<>();
        this.hasher = plaintext -> {
            String hashed = null;
            try {
                hashed = Base64.getEncoder().encodeToString(plaintext.getBytes("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return hashed;
        };

        for (int i = 0; i < usernames.length && i < passwords.length; i++) {
            userMap.put(usernames[i], hasher.apply(passwords[i]));
        }
    }

    public boolean validate(String username, String password) {
        String hashed = hasher.apply(password);
        return userMap.containsKey(username) && userMap.get(username).equals(hashed);
    }

    public static void main(String[] args) {
        String[] usernames = {"admin", "user1", "user2"};
        String[] passwords = {"password1", "password2", "password3"};
        CredentialValidator validator = new CredentialValidator(usernames, passwords);

        boolean valid = validator.validate("admin", "password1");
        System.out.println("Credentials valid: " + valid);

        valid = validator.validate("user1", "wrongpassword");
        System.out.println("Credentials valid: " + valid);
    }
}