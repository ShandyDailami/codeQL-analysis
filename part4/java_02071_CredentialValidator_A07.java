import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;

public class java_02071_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(X509Certificate certificate) throws CertificateException {
        // A07_AuthFailure - if certificate is null, fail
        if (certificate == null) {
            return CredentialValidationResult.failed("Certificate is null");
        }

        // A07_AuthFailure - if certificate is expired, fail
        if (certificate.getNotAfter().before(new java.util.Date())) {
            return CredentialValidationResult.failed("Certificate is expired");
        }

        // A07_AuthFailure - if certificate is not valid, fail
        X500Principal issuer = new X500Principal(certificate.getIssuerX500Principal().getName());
        if (!issuer.getName().equals("CN=YourCompany, OU=YourDepartment, O=YourCompany, C=US")) {
            return CredentialValidationResult.failed("Issuer is not valid");
        }

        // If everything is fine, return success
        return CredentialValidationResult.success();
    }
}