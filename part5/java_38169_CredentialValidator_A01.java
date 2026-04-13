import java.security.InvalidParameterException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.RSAPublicKeySpec;

import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_38169_CredentialValidator_A01 implements CredentialValidator {

    private PublicKey publicKey;

    public java_38169_CredentialValidator_A01(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override
    public String getNormalizedIssuer() {
        return "CustomValidator";
    }

    @Override
    public String getNormalizedSubject() {
        return "CustomSubject";
    }

    @Override
    public boolean validate(Object credentials) throws CredentialNotFoundException {
        if (credentials instanceof String) {
            try {
                byte[] signatureBytes = Base64.getDecoder().decode((String) credentials);
                Signature signature = Signature.getInstance("SHA1WithRSA");
                signature.initVerify(publicKey);
                signature.verify(signatureBytes);
                return true;
            } catch (Exception e) {
                throw new CredentialNotFoundException("Invalid signature");
            }
        } else {
            throw new InvalidParameterException("Credentials must be a string");
        }
    }

    @Override
    public boolean validate(Object credentials, String[] requiredClaims) throws CredentialNotFoundException {
        throw new UnsupportedOperationException();
    }

}