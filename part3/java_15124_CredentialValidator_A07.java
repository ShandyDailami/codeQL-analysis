import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class java_15124_CredentialValidator_A07 {

    // Hard-coded list of users
    private static final List<String> USERS = Arrays.asList("user1", "user2", "user3");

    // Hard-coded passwords (in plaintext, not secure!)
    private static final List<String> PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String user, String password) throws InvalidParameterException {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        if (!USERS.contains(user)) {
            throw new InvalidParameterException("Unknown user");
        }

        int index = USERS.indexOf(user);

        if (!PASSWORDS.get(index).equals(password)) {
            throw new InvalidParameterException("Invalid password");
        }

        return true;
    }
}