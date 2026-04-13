import java.util.Arrays;
import java.util.List;

public class java_01504_CredentialValidator_A03 {
    private static final List<String> BANNED_WORDS = Arrays.asList("bad", "worse", "hate", "black", "white");

    public boolean validate(String username) {
        for (String bannedWord : BANNED_WORDS) {
            if (username.contains(bannedWord)) {
                System.out.println("Username contains banned word, validation failed!");
                return false;
            }
        }
        System.out.println("Username is valid, proceeding with authentication!");
        return true;
    }
}