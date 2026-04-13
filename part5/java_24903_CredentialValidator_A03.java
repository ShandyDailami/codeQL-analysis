import java.util.HashSet;
import java.util.Set;

public class java_24903_CredentialValidator_A03 {

    private static final Set<String> SPECIAL_WORDS = new HashSet<String>() {{
        add("password");
        add("admin");
        add("superuser");
        // add more specific words here if any
    }};

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        password = password.toLowerCase();

        // Check if password contains any special words
        for (String word : SPECIAL_WORDS) {
            if (password.contains(word)) {
                return false;
            }
        }

        // If password does not contain any special words, return true
        return true;
    }

}