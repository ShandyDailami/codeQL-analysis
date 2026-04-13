import java.util.Base64;

public class java_08386_CredentialValidator_A03 implements CredentialValidator {

    private String adminUsername;

    public java_08386_CredentialValidator_A03() {
        // This should be a secure way to set the admin username
        adminUsername = new String(Base64.getDecoder().decode("MTIzNA=="));
    }

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        String presentedUsername = new String(Base64.getDecoder().decode(c.getCredentialIdentifier()));

        if (presentedUsername.equals(adminUsername)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username provided");
        }
    }
}