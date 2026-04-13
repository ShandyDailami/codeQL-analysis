import java.util.regex.Pattern;

public class java_38229_CredentialValidator_A08 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])(?=\\S+$).{8,}$");

    @Override
    public boolean authenticate(String password) {
        return passwordPattern.matcher(password).matches();
    }

    @Override
    public boolean integrity(String password, String salt) {
        return authenticate(password);
    }

    @Override
    public boolean integrityFailure(String password, String salt) {
        return !authenticate(password);
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();

        System.out.println(validator.authenticate("password")); // Outputs: false
        System.out.println(validator.integrity("password", "salt")); // Outputs: false
        System.out.println(validator.integrityFailure("password", "salt")); // Outputs: true
    }
}