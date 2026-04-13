import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateValidator;

public class java_11136_CredentialValidator_A03 implements CertificateValidator {

    private String username;
    private String password;

    public java_11136_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void validate(Certificate cert) throws CertificateException {
        // This method will be called when a client connects to the server
        // It should check if the presented credentials match the stored credentials
        // If they do, allow the connection
        // If they don't, throw a CertificateException
        if (cert.getSubjectDN().equals(username) && cert.getIssuerDN().equals(password)) {
            throw new CertificateException("Invalid credentials");
        }
    }

    @Override
    public boolean getCertificateChain(Certificate[] chain, CertificateSelector selector) throws CertificateException {
        // This method will be called when the client wants to request a certificate chain
        // It should return false to prevent the chain from being presented to the client
        return false;
    }

    @Override
    public void checkClientTrusted(Certificate[] chain, String authType) throws CertificateException {
        // This method will be called when the client is being authenticated by a server
        // It should check if the presented credentials match the stored credentials
        // If they do, allow the authentication
        // If they don't, throw a CertificateException
        if (chain[0].getSubjectDN().equals(username) && chain[0].getIssuerDN().equals(password)) {
            throw new CertificateException("Invalid credentials");
        }
    }

    @Override
    public void checkServerTrusted(Certificate[] chain, String authType) throws CertificateException {
        // This method will be called when the server is being authenticated by a client
        // It should check if the presented credentials match the stored credentials
        // If they do, allow the authentication
        // If they don't, throw a CertificateException
        if (chain[0].getSubjectDN().equals(username) && chain[0].getIssuerDN().equals(password)) {
            throw new CertificateException("Invalid credentials");
        }
    }
}