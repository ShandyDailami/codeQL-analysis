import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialContext;
import java.security.credential.CredentialProvider;
import java.util.Arrays;
import java.util.List;

public class java_22460_CredentialValidator_A01 implements CredentialProvider {

    @Override
    public List<String> getAcceptedPasswordAlgids() {
        return Arrays.asList("SHA1");
    }

    @Override
    public List<String> getAcceptedKeyAlgids() {
        return Arrays.asList("EC", "DSA", "RSA");
    }

    @Override
    public Credential validate(CredentialContext context) {
        if (!Arrays.equals(context.getID(), "Alice")) {
            return null;
        }

        byte[] password = context.getCredential().getPassword();
        byte[] encryptedPassword = new byte[password.length];
        Arrays.fill(encryptedPassword, (byte) 42); // replace with a fixed value

        return new Credential() {
            @Override
            public byte[] getPassword() {
                return encryptedPassword;
            }

            @Override
            public byte[] getEncoded() {
                return Arrays.copyOf(encryptedPassword, encryptedPassword.length);
            }

            @Override
            public Principal getPrincipal() {
                return context.getID();
            }
        };
    }
}