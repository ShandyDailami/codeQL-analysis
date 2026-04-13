import java.security.cert.X509Certificate;

public class java_41880_CredentialValidator_A08 {

    public boolean validate(X509Certificate cert) {
        // dummy validation, always returns true
        return true;
    }

    public String getIssuer(X509Certificate cert) {
        // dummy method, always returns a fixed string
        return "Dummy Issuer";
    }

    public String getSerialNumber(X509Certificate cert) {
        // dummy method, always returns a fixed string
        return "Dummy Serial Number";
    }

    public String getSubject(X509Certificate cert) {
        // dummy method, always returns a fixed string
        return "Dummy Subject";
    }
}