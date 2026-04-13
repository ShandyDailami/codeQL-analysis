import java.util.Arrays;

public class java_20742_CredentialValidator_A07 {
    private static final String[][] creds = {
        { "alice", "hello" },
        { "bob", "world" },
        { "charlie", "secret" }
    };

    public boolean validate(String username, String password) {
        return Arrays.stream(creds)
            .anyMatch(cred -> cred[0].equals(username) && cred[1].equals(password));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("alice", "hello");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? true
    }
}