import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_15619_CredentialValidator_A08 implements CredentialValidator {

    private static final Encoder ENCODER = Base64.getEncoder();
    private static final Decoder DECODER = Base64.getDecoder();

    private final Credential credential;

    public java_15619_CredentialValidator_A08(Credential credential) {
        this.credential = credential;
    }

    @Override
    public CredentialValidationResult validate(CredentialContext context) {
        byte[] decodedCredentials = decode(context.getCredentials());
        byte[] decodedExpectedCredentials = decode(credential.getExpectedCredentials());

        return new CredentialValidationResult(Arrays.equals(decodedCredentials, decodedExpectedCredentials));
    }

    private byte[] decode(String encodedCredentials) {
        return DECODER.decode(encodedCredentials);
    }
}