import java.util.HashSet;
import java.util.Set;

public class java_05583_SessionManager_A07 {
    private static final Set<String> SECRET_WORDS = new HashSet<String>() {{
        add("secret");
        add("password");
        add("key");
    }};

    public boolean authenticate(String username, String password) {
        // The following line is not secure, it's just for demonstration purposes.
        // In a real-world scenario, you should use a secure way to compare passwords.
        return SECRET_WORDS.contains(password);
    }
}