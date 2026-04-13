import javax.security.auth.Credential;
import javax.security.auth.InvalidCredentialDataException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_14471_CredentialValidator_A08 {

    public boolean validate(Credential credential) {
        try {
            String password = credential.getPassword();
            if (password.equals("legacyPassword")) {
                return true;
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } catch (CredentialNotFoundException e) {
            System.out.println("Credential not found");
        } catch (InvalidCredentialDataException e) {
            System.out.println("Invalid credential data");
        } catch (LoginException e) {
            System.out.println("Login failed");
        } catch (Exception e) {
            System.out.println("An error occurred");
        }
        return false;
    }
}