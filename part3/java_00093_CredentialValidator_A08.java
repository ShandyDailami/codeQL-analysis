import javax.security.auth.Subject;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashSet;
import java.util.Set;

public class java_00093_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {

    private Set<String> allowedUsernames = new HashSet<>();

    public java_00093_CredentialValidator_A08() {
        allowedUsernames.add("user1");
        allowedUsernames.add("user2");
        // add more usernames as needed
    }

    @Override
    public Set<String> getAcceptedIssuerAliases() {
        return null;
    }

    @Override
    public boolean validate(Subject subject) {
        return subject.getPrincipals().size() > 0 && allowedUsernames.contains(subject.getPrincipals().iterator().next());
    }

    @Override
    public boolean validate(X509Certificate certificate) {
        return false;
    }

    @Override
    public boolean validate(RSAPublicKey publicKey) {
        return false;
    }

    @Override
    public boolean validate(RSAPrivateKey privateKey) {
        return false;
    }
}