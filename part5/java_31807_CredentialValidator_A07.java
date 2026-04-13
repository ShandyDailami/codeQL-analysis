import java.security.cert.X509Certificate;

public class java_31807_CredentialValidator_A07 implements CredentialValidator {

    private String acceptableIssuer;

    public java_31807_CredentialValidator_A07(String acceptableIssuer) {
        this.acceptableIssuer = acceptableIssuer;
    }

    @Override
    public boolean validate(X509Certificate cert) {
        if (acceptableIssuer == null || cert.getIssuer().equals(acceptableIssuer)) {
            return true;
        } else {
            return false;
        }
    }
}