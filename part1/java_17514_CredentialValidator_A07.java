import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.GuardianInfo;
import java.security.GuardianInfoListener;
import java.security.GuardianInfoService;
import java.security.PrivateKey;
import java.security.PrivateKeyListener;
import java.security.PrivateKeyService;
import java.security.UnrecoverableEncryptionException;
import java.security.cert.Certificate;

public class java_17514_CredentialValidator_A07 implements CredentialValidator {

    private CertificateValidator certValidator;
    private PrivateKeyValidator privKeyValidator;
    private GuardianInfoService guardianInfoService;

    public java_17514_CredentialValidator_A07() {
        certValidator = new CertificateValidator();
        privKeyValidator = new PrivateKeyValidator();
        guardianInfoService = new GuardianInfoService();
    }

    @Override
    public void validate(Credential credential, UsernamePasswordCredential usernamePasswordCredential, CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException, AccessControlException, UnrecoverableEncryptionException {

        // Validate Certificate
        certValidator.validate(credential.getCertificate(), usernamePasswordCredential.getPassword());

        // Validate Private Key
        privKeyValidator.validate(credential.getPrivateKey(), usernamePasswordCredential.getPassword());

        // Validate Guardian Info
        GuardianInfo guardianInfo = guardianInfoService.getGuardianInfo("");
        guardianInfoService.setGuardianInfoListener((GuardianInfoListener) guardianInfo);
        guardianInfoService.validate(guardianInfo);
    }
}