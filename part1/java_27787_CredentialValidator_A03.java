import java.security.Mechanism$Key;
import java.security.Mechanism;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class java_27787_CredentialValidator_A03 {

    private Set<Character> allowedCharacters;
    private Set<String> disallowedPasswords;
    private Mechanism.Key key;

    public java_27787_CredentialValidator_A03() {
        allowedCharacters = new HashSet<>();
        disallowedPasswords = new HashSet<>();
        allowedCharacters.add('A');
        allowedCharacters.add('B');
        allowedCharacters.add('C');
        disallowedPasswords.add("password");
        disallowedPasswords.add("123456");

        key = new Mechanism.Key() {
            @Override
            public String getAlgorithm() {
                return "PBKDF2WithSHA1";
            }

            @Override
            public byte[] getEncoded() {
                return new byte[0];
            }
        };
    }

    public boolean validate(String password) {
        if (password == null) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (!allowedCharacters.contains(c)) {
                return false;
            }
        }

        if (disallowedPasswords.contains(password)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Testing the validator
        String[] testPasswords = {"A1B2C3", "password", "123456", "Awesome1"};

        for (String password : testPasswords) {
            if (!validator.validate(password)) {
                System.out.println("Failed to validate password: " + password);
            } else {
                System.out.println("Password is valid: " + password);
            }
        }
    }
}