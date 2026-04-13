import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_30234_CredentialValidator_A03 {

    private static final Set<String> DISALLOWED_WORDS = new HashSet<>(Arrays.asList("bad", "worse", "ugly", "hack", "drop", "hacked"));

    public boolean validate(String username) {
        String[] parts = username.split("\\s+");
        for (String part : parts) {
            if (DISALLOWED_WORDS.contains(part)) {
                System.out.println("Disallowed username detected: " + username);
                return false;
            }
        }
        return true;
    }
}