import java.util.Arrays;
import java.util.List;

public class java_25548_CredentialValidator_A01 {

    private static final List<String> PROHIBITED_WORDS = Arrays.asList("bad", "worse", "vulnerable", "hack", "dangerous", "danger");

    public boolean isPasswordProhibited(String password) {
        String[] words = password.split(" ");
        for (String word : words) {
            if (PROHIBITED_WORDS.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}