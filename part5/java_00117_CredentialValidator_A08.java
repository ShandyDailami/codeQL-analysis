import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;
import java.util.Collection;
import javax.security.auth.callback.*;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.UnknownCredentialException;
import javax.security.auth.callback.Callback;
import java.util.HashSet;

public class java_00117_CredentialValidator_A08 implements CallbackHandler {
    private Set<X509Certificate> acceptedCertificates;

    public java_00117_CredentialValidator_A08() {
        this.acceptedCertificates = new HashSet<X509Certificate>();
    }

    @Override
    public String getCallerPrincipal(Callback callback) throws CredentialNotFoundException, UnknownCredentialException {
        throw new UnknownCredentialException("CredentialValidator.getCallerPrincipal called");
    }

    @Override
    public String getPassword(Callback callback) throws CredentialNotFoundException, UnknownCredentialException {
        throw new UnknownCredentialException("CredentialValidator.getPassword called");
    }

    @Override
    public void initialize(Callback callback) throws CredentialNotFoundException, UnknownCredentialException {
        throw new UnknownCredentialException("CredentialValidator.initialize called");
    }

    @Override
    public boolean validate(Callback callback, X509Certificate cert) throws CredentialNotFoundException, UnknownCredentialException {
        if (acceptedCertificates.contains(cert)) {
            return true;
        } else {
            throw new UnknownCredentialException("Invalid certificate");
        }
    }
}