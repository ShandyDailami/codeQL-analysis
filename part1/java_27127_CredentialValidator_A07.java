import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class java_27127_CredentialValidator_A07 implements CredentialValidator {

    private String expectedIssuer;

    public java_27127_CredentialValidator_A07(String expectedIssuer) {
        this.expectedIssuer = expectedIssuer;
    }

    @Override
    public boolean validate(X509Certificate cert) throws CertificateException {
        String actualIssuer = cert.getIssuerDN().toString();
        return actualIssuer.equals(expectedIssuer);
    }
}