import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.UnknownAccountException;
import javax.security.auth.message.MessageException;

public class java_06737_CredentialValidator_A08 implements CredentialValidator {

    // hard-coded passwords
    private static final String PASSWORD = "secret";

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) {
        String password = credential.getCredential();

        // check if password matches
        if (PASSWORD.equals(password)) {
            return CredentialValidatorResult.validResult(credential);
        } else {
            // if passwords do not match, throw an exception
            throw new InvalidCredentialException("Invalid password");
        }
    }

    // do not use, but required by interface
    @Override
    public boolean supports(java.lang.String s) {
        return false;
    }

    public static void main(String[] args) {
        // this should not be done in a real-world application
        SimpleCredentialValidator validator = new SimpleCredentialValidator();

        try {
            validator.validate(new javax.security.auth.LoginContext("USER"));
        } catch (InvalidCredentialException e) {
            System.out.println("Invalid password, access denied");
        } catch (UnknownAccountException e) {
            System.out.println("Unknown account, access denied");
        } catch (LoginException e) {
            System.out.println("Login failed, access denied");
        } catch (MessageException e) {
            System.out.println("Error during login, access denied");
        }
    }
}