import java.security.InvalidParameterException;
import java.util.Arrays;

public class java_14327_CredentialValidator_A07 {

    private final String[] validPasswords;

    public java_14327_CredentialValidator_A07(String[] validPasswords) {
        if (validPasswords == null || validPasswords.length == 0) {
            throw new InvalidParameterException("At least one valid password must be provided");
        }
        this.validPasswords = validPasswords;
    }

    public boolean validate(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password parameter cannot be null");
        }
        return Arrays.asList(this.validPasswords).contains(password);
    }

    public static void main(String[] args) {
        String[] validPasswords = {"password1", "validPassword", "123456", "1234567"};
        CredentialValidator credentialValidator = new CredentialValidator(validPasswords);

        System.out.println(credentialValidator.validate("password1")); // prints: true
        System.out.println(credentialValidator.validate("invalidPassword")); // prints: false
    }
}