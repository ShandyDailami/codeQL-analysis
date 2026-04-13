import java.security.cert.X509Certificate;
import java.util.Arrays;

public class java_18459_CredentialValidator_A08 {
    private static final String[] SPECIAL_CERTS = new String[] {
        "CN=John Doe, OU=MyOrg, OU=MyDep, OU=MySub, CN=MySite, L=MyCity, ST=MyState, C=MY",
        "CN=John Doe, OU=MyOrg, OU=MySub, CN=MySite, L=MyCity, ST=MyState, C=MY"
    };

    public boolean validate(X509Certificate cert) {
        String certString = cert.getSubjectX500Principal();
        return Arrays.asList(SPECIAL_CERTS).contains(certString);
    }
}