import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

public class java_12194_CredentialValidator_A03 {
    private static final List<String> ALLOWED_PROVIDERS = Arrays.asList("BC", "SC", "OS");
    private static final Provider[] ALLOWED_PROVIDERS_OBJECTS = {
        Security.getProvider("BC"),
        Security.getProvider("SunCertificate"),
        Security.getProvider("SunJSSE")
    };

    public boolean validateCredentials(String userName, String password) {
        if (userName == null || password == null) {
            return false;
        }

        if (!ALLOWED_PROVIDERS.contains(getProviderName(userName))) {
            return false;
        }

        if (!Arrays.asList(userName.split("@")).get(0).equals(userName)) {
            return false;
        }

        return true;
    }

    private String getProviderName(String userName) {
        String[] splitUserName = userName.split("@");
        if (splitUserName.length == 2) {
            return splitUserName[1];
        }
        return "";
    }
}