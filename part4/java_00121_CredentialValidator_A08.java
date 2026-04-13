import java.security.InvalidParameterException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class java_00121_CredentialValidator_A08 {

    public boolean validate(String userId, Certificate[] certificates) {
        // a simple validation, checks if the userId is not null or empty
        if (userId == null || userId.isEmpty()) {
            throw new InvalidParameterException("User ID must be provided");
        }

        // if no certificates provided, return false
        if (certificates == null || certificates.length == 0) {
            return false;
        }

        // assuming the certificates array contains only one certificate
        Certificate certificate = certificates[0];

        // if the certificate is null or has no subjectDN, return false
        if (certificate == null || certificate.getSubjectDN() == null) {
            return false;
        }

        // assuming the subjectDN is a username
        String subjectDN = certificate.getSubjectDN().toString();

        // check if the userId matches the subjectDN
        return userId.equals(subjectDN);
    }
}