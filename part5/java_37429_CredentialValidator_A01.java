import javax.security.auth.credential.*;
import javax.security.auth.Subject;

public class java_37429_CredentialValidator_A01 implements CredentialValidator {

    private static final String STRENGTH_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$";

    @Override
    public boolean validate(Subject subject, Credential credential) {
        String password = credential.getPassword();
        return password.matches(STRENGTH_REGEX);
    }

    @Override
    public boolean validate(Subject subject, Credential credential, String target) {
        return false;
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();
        PlainCredential credential = new PlainCredential("password");
        try {
            if (validator.validate(null, credential)) {
                System.out.println("Password is strong");
            } else {
                System.out.println("Password is not strong");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}