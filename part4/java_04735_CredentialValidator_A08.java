import java.util.Arrays;
import java.util.List;

public class java_04735_CredentialValidator_A08 {
    private List<String> validPasswords;

    public java_04735_CredentialValidator_A08() {
        validPasswords = Arrays.asList("password1", "password2", "password3"); // Add more passwords as needed
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        for (String validPassword : validPasswords) {
            if (validPassword.equals(password)) {
                return true;
            }
        }

        return false;
    }
}