import java.security.cert.Certificate;
import java.util.Arrays;

public class java_37425_CredentialValidator_A08 implements CredentialValidator {

    private static final String PURPOSES = "integrity-failure";

    private final String[] acceptablePurposes = { PURPOSES };

    @Override
    public String[] getAcceptablePurposes() {
        return this.acceptablePurposes;
    }

    @Override
    public boolean validate(Certificate cert, String purpose) throws CredentialValidatorException {
        if (!Arrays.asList(this.acceptablePurposes).contains(purpose)) {
            throw new CredentialValidatorException("Invalid purpose: " + purpose);
        }

        // Simulate an integrity failure by returning false.
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new MyCredentialValidator();

        try {
            validator.validate(null, PURPOSES); // This should fail
        } catch (CredentialValidatorException e) {
            System.out.println("Expected failure, but got: " + e.getMessage());
        }
    }
}