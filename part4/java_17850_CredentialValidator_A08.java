import java.util.ArrayList;
import java.util.List;

public class java_17850_CredentialValidator_A08 {
    // predefined set of known passwords
    private static final List<String> KNOWN_PASSWORDS = new ArrayList<>();
    static {
        KNOWN_PASSWORDS.add("password1");
        KNOWN_PASSWORDS.add("password2");
        KNOWN_PASSWORDS.add("password3");
    }

    public boolean validate(String enteredPassword) {
        if (KNOWN_PASSWORDS.contains(enteredPassword)) {
            // if password is in the known passwords, return true
            return true;
        } else {
            // if password is not in the known passwords, return false
            throw new IntegrityFailure("Entered password does not match known passwords");
        }
    }
}