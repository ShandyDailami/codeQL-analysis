import java.security.SecureRandom;

public class java_14493_CredentialValidator_A08 implements CredentialValidator {

    private SecureRandom random = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "0123456789" +
            "~` CircuitLab!@#$%^&*()_+=-{}[]|\\:;\"'<,>.? ";

    @Override
    public boolean validate(Credential credential) throws CredentialValidationException {
        String presentedPassword = new String(credential.getCredentials());
        StringBuilder verificationString = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            verificationString.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        if (presentedPassword.equals(verificationString.toString())) {
            return true;
        } else {
            throw new CredentialValidationException("Invalid password");
        }
    }
}