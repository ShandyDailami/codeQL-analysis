import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

public class java_08547_CredentialValidator_A08 implements java.security.Authenticator {
    private String userName;
    private String password;

    // Constructor
    public java_08547_CredentialValidator_A08(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Certificate authenticate(String s, Certificate certificate) {
        // If the username and password match, return the certificate
        if (this.userName.equals(s) && this.password.equals(new String(Base64.getDecoder().decode(certificate.toString())))) {
            return certificate;
        } else {
            throw new java.security.AuthenticationFailedException("Invalid credentials");
        }
    }
}