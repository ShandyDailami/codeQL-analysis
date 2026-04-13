import java.util.Base64;

public class java_32729_CredentialValidator_A01 {

    private static final String VALID_USER = "testUser";
    private static final String VALID_PASSWORD = "testPassword";

    public boolean validate(String user, String password) {
        byte[] decodedCredentials = Base64.getDecoder().decode(user);
        String decodedUser = new String(decodedCredentials, 0, decodedCredentials.length);
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        return decodedUser.equals(VALID_USER) && decodedPassword.equals(VALID_PASSWORD);
    }
}