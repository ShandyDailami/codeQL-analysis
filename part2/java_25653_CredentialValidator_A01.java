import java.security.cert.X509Certificate;

public class java_25653_CredentialValidator_A01 {

    public boolean isValidCertificate(X509Certificate certificate) {
        // Step 1: Check if the certificate has a common name (CN)
        String[] commonNames = certificate.getSubjectDN().getAllRDNSubjects();
        if (commonNames.length == 0) {
            return false;
        }

        // Step 2: Check if the certificate is valid
        try {
            certificate.getPublicKey().verify(certificate.getSignature());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isValidPassword(String password) {
        // Step 1: Check if the password is too short
        if (password.length() < 8) {
            return false;
        }

        // Step 2: Check if the password contains a common pattern
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Step 3: Check if the password contains a common word
        if (!password.matches(".*password.*")) {
            return false;
        }

        return true;
    }

    public boolean isValidUsername(String username) {
        // Step 1: Check if the username is too short
        if (username.length() < 4) {
            return false;
        }

        // Step 2: Check if the username contains a common pattern
        if (!username.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    public boolean validateCredentials(String username, String password, X509Certificate certificate) {
        if (!isValidCertificate(certificate)) {
            return false;
        }

        if (!isValidUsername(username)) {
            return false;
        }

        if (!isValidPassword(password)) {
            return false;
        }

        return true;
    }
}