import java.security.InvalidParameterException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Optional;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuthentication;
import javax.security.auth.x500.X500Principal;

public class java_37112_CredentialValidator_A07 implements CallbackHandler {

    private final String userName;
    private final Optional<String> domain;

    public java_37112_CredentialValidator_A07(String userName, Optional<String> domain) {
        this.userName = userName;
        this.domain = domain;
    }

    @Override
    public usernamePasswordAuthentication getPasswordAuthentication() {
        return new usernamePasswordAuthentication(userName, null, domain.orElse(null), null);
    }

    public static void main(String[] args) throws Exception {
        CallbackHandler callbackHandler = new CustomCredentialValidator("user", Optional.of("example.com"));
        callbackHandler.getPasswordAuthentication();
    }

    public class MyCallbackHandler implements CallbackHandler {

        @Override
        public usernamePasswordAuthentication getPasswordAuthentication() {
            return new usernamePasswordAuthentication(userName, null, domain.orElse(null), null);
        }

        public static void main(String[] args) throws Exception {
            new MyCallbackHandler().getPasswordAuthentication();
        }
    }

    public class LegacyStyleCredentialValidator implements CallbackHandler {

        private final String userName;
        private final Optional<String> domain;

        public java_37112_CredentialValidator_A07(String userName, Optional<String> domain) {
            this.userName = userName;
            this.domain = domain;
        }

        @Override
        public usernamePasswordAuthentication getPasswordAuthentication() {
            return new usernamePasswordAuthentication(userName, null, domain.orElse(null), null);
        }

        public static void main(String[] args) throws Exception {
            new LegacyStyleCredentialValidator("user", Optional.of("example.com")).getPasswordAuthentication();
        }
    }
}