import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;

public class java_33852_CredentialValidator_A03 implements CredentialValidator {

    // This will hold the expected username and password
    private String expectedUsername;
    private String expectedPassword;

    // The constructor takes the expected username and password
    public java_33852_CredentialValidator_A03(String username, String password) {
        this.expectedUsername = username;
        this.expectedPassword = password;
    }

    @Override
    public String getCallerName() {
        return "Unknown Caller";
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential)
            throws CredentialNotFoundException, LoginException {

        // Decode the expected username and password
        Optional<String> decodedUsername = decodeString(expectedUsername);
        Optional<String> decodedPassword = decodeString(expectedPassword);

        // Check if the provided username and password match the expected values
        if(decodedUsername.isPresent() && decodedPassword.isPresent()) {
            if(decodedUsername.get().equals(credential.getCallerPrincipal())
                && decodedPassword.get().equals(credential.getCredentials())) {
                return true;
            }
        }

        // In case of failure
        throw new CredentialNotFoundException("Invalid username or password");
    }

    // Method to decode a Base64 encoded String
    private Optional<String> decodeString(String strToDecode) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(strToDecode);
            return Optional.of(new String(decodedBytes));
        } catch (IllegalArgumentException e) {
            // In case of an invalid Base64 string
            return Optional.empty();
        }
    }

}