import java.security.cert.X509Certificate;
import javafx.util.Pair;

public class java_11487_CredentialValidator_A07 implements CredentialValidator {

    private static final String CORP_ID = "A07_AuthFailure";
    private static final String AUTH_FAILURE = "AuthFailure";
    private static final String AUTHENTICATION_SERVICE = "Authentication Service";
    private static final String CORP_SVC_ID = "Corp Svc ID";

    @Override
    public Pair<String, String> validate(X509Certificate cert) {
        String credential = cert.getSubjectDN().get(0).toString();
        if (credential.matches(CORP_ID) && AUTH_FAILURE.equals(credential.split("CN=")[1])) {
            return new Pair<>(AUTHENTICATION_SERVICE, CORP_SVC_ID);
        } else {
            return null;
        }
    }
}