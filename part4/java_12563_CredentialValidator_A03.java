import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class java_12563_CredentialValidator_A03 {
    private static final Set<String> FORBIDDEN_WORDS = new HashSet<>();

    static {
        FORBIDDEN_WORDS.add("badword1");
        FORBIDDEN_WORDS.add("badword2");
        // you can add more words here
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        // check if username contains forbidden words
        if (containsForbiddenWords(username)) {
            System.out.println("Username contains forbidden words. Validation failed.");
            return false;
        }

        // check if password contains forbidden words
        if (containsForbiddenWords(password)) {
            System.out.println("Password contains forbidden words. Validation failed.");
            return false;
        }

        // if neither of the above conditions is met, the credentials are valid
        System.out.println("Validation successful.");
        return true;
    }

    private boolean containsForbiddenWords(String input) {
        String[] words = input.split(" ");
        for (String word : words) {
            if (FORBIDDEN_WORDS.contains(word)) {
                return true;
            }
        }
        return false;
    }
}