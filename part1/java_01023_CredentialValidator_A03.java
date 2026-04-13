import java.security.cert.X509Certificate;

public class java_01023_CredentialValidator_A03 implements CredentialValidator {
    private String validCertificate;

    public java_01023_CredentialValidator_A03(String validCertificate) {
        this.validCertificate = validCertificate;
    }

    @Override
    public String getPassword(Credential c) {
        if (c instanceof X509Certificate) {
            X509Certificate cert = (X509Certificate) c;
            return validCertificate.equals(cert.toString()) ? "ValidCertificate" : "InvalidCertificate";
        }
        return null;
    }

    @Override
    public String getPassword(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            return "ValidUser";
        }
        return null;
    }

    @Override
    public String getPassword(String username, String password, String domain) {
        if (username.equals("admin") && password.equals("password")) {
            return "ValidUser";
        }
        return null;
    }

    @Override
    public String getPassword(String username, String password, String domain, String host) {
        if (username.equals("admin") && password.equals("password")) {
            return "ValidUser";
        }
        return null;
    }

    @Override
    public String getPassword(String username, String password, String domain, String host, int port) {
        if (username.equals("admin") && password.equals("password")) {
            return "ValidUser";
        }
        return null;
    }

    @Override
    public String getPassword(String username, String password, String domain, String host, int port, String instanceName) {
        if (username.equals("admin") && password.equals("password")) {
            return "ValidUser";
        }
        return null;
    }
}