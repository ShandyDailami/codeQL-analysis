import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_26226_CredentialValidator_A07 implements CredentialValidator {

    // List of disallowed usernames
    private final Set<String> disallowedUsernames = new HashSet<>(Arrays.asList(
            "disallowed1",
            "disallowed2",
            "disallowed3"
    ));

    @Override
    public boolean validate(String username) throws InvalidParameterException {
        // Check if username is in disallowed usernames
        return !disallowedUsernames.contains(username);
    }
}