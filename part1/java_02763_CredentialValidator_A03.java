import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialValidationResult;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;

public class java_02763_CredentialValidator_A03 implements java.security.credential.CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) {

        // Decoding the credential
        String decodedCredential = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));

        // Splitting the decoded credential into username and password
        String[] credentialParts = decodedCredential.split(":");

        // Validating the username and password
        if ("admin".equals(credentialParts[0]) && "password".equals(credentialParts[1])) {
            return CredentialValidationResult.validResult(new Principal() {
                @Override
                public String getName() {
                    return credentialParts[0];
                }
            });
        } else {
            return CredentialValidationResult.invalidResult("Invalid credentials");
        }
    }
}