import javax.security.auth.CredentialValidator;
import javax.security.auth.login.CredentialException;
import java.util.Base64;

public class java_07954_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public String getCallerName() {
        return "CustomCredentialValidator";
    }

    @Override
    public String getQualifiedCallerName() {
        return "CustomCredentialValidator";
    }

    @Override
    public String validate(String callerName, String arg) throws CredentialException {
        // Decoding the username and password from the base64 string
        byte[] decodedArg = Base64.getDecoder().decode(arg);
        String decodedStr = new String(decodedArg);
        String username = decodedStr.split(":")[0];
        String password = decodedStr.split(":")[1];

        // Checking if the username and password are correct
        if (username.equals("admin") && password.equals("password")) {
            return "Successfully authenticated";
        } else {
            throw new CredentialException("Invalid username or password");
        }
    }
}