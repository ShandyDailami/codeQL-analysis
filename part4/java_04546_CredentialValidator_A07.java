import java.security.cert.X509Certificate;

public class java_04546_CredentialValidator_A07 implements javax.security.auth.login.CredentialValidator {

    @Override
    public X509Certificate[] validate(X509Certificate[] certificates) {
        // If there are no certificates, the validate method returns null.
        // This indicates that the presented authentication credentials are invalid.
        if (certificates == null || certificates.length == 0) {
            return null;
        }

        // Otherwise, return the certificate.
        return certificates;
    }

    @Override
    public String getNormativeAccount() {
        // This method returns a hint about what the normative account is.
        // In this case, it returns null.
        return null;
    }

}