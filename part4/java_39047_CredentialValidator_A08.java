import java.security.cert.X509Certificate;
import java.util.Arrays;

public class java_39047_CredentialValidator_A08 implements CredentialValidator {

    private static final String INTEGRITY_FAILURE = "Integrity failure";

    @Override
    public Result validate(Credential credential) {
        String password = (String) credential.getCredentialIdentifier();
        X509Certificate[] chain = (X509Certificate[]) credential.getCredential();

        if (password == null || password.trim().isEmpty()) {
            return new Result(INTEGRITY_FAILURE, Arrays.toString(chain));
        }

        if (chain == null || chain.length == 0) {
            return new Result(INTEGRITY_FAILURE, Arrays.toString(chain));
        }

        return new Result(INTEGRITY_FAILURE, Arrays.toString(chain));
    }

    public static class Result {
        private final String message;
        private final String details;

        public java_39047_CredentialValidator_A08(String message, String details) {
            this.message = message;
            this.details = details;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }
    }
}