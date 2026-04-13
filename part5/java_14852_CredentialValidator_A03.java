import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;

public class java_14852_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(X509Certificate certificate) throws CertificateException {
        return CredentialValidatorResult.invalidCredentials();
    }

    @Override
    public CredentialValidatorResult validate(X509Certificate certificate, Object credentials) throws CertificateException {
        return CredentialValidatorResult.invalidCredentials();
    }

    @Override
    public CredentialValidatorResult validate(X509Certificate certificate, Object credentials, X500Principal principal) throws CertificateException {
        return CredentialValidatorResult.invalidCredentials();
    }

}