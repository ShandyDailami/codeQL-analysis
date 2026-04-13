import javax.naming.AuthenticationException;
import java.util.Base64;

public class java_35069_CredentialValidator_A03 {

    private static final String AUTHORIZED_USERS = "testUser";
    private static final String AUTHORIZED_PASSWORDS = "testPassword";

    public boolean validate(String user, String password) throws AuthenticationException {
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        if(user.equals(AUTHORIZED_USERS) && decodedPassword.equals(AUTHORIZED_PASSWORDS)) {
            return true;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        try {
            CredentialValidator validator = new CredentialValidator();
            validator.validate("testUser", Base64.getEncoder().encodeToString("testPassword".getBytes()));
            System.out.println("Access granted");
        } catch (AuthenticationException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}