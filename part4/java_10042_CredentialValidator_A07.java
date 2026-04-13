import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialDataException;
import javax.security.auth.login.LoginException;

public class java_10042_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_10042_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String validate(String arg0) throws InvalidCredentialDataException {
        String credential = new String(Base64.getDecoder().decode(arg0));
        if (this.credentials.containsKey(credential.split(":")[0]) &&
                this.credentials.get(credential.split(":")[0]).equals(credential.split(":")[1])) {
            return null;
        } else {
            throw new InvalidCredentialDataException("Invalid credentials");
        }
    }

    @Override
    public boolean validate(String arg0, String arg1) throws InvalidCredentialDataException, LoginException {
        return false;
    }
}