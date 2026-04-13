import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Optional;
import java.util.stream.Stream;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.CryptoUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class java_12305_CredentialValidator_A07 implements CredentialValidator {
    private static final String PROVIDER = BouncyCastleProvider.NAME;

    private Optional<KeyStore> keyStoreOpt;
    private Optional<Certificate> certOpt;

    public java_12305_CredentialValidator_A07(CallbackHandler callbackHandler, KeyStore keyStore, Certificate certificate) {
        keyStoreOpt = Optional.of(keyStore);
        certOpt = Optional.of(certificate);

        new LoginModule("", callbackHandler).validate(new Callback[]{new CredentialAwareCallback(this)});
    }

    public boolean validate(Credential credential) {
        if (keyStoreOpt.isPresent() && certOpt.isPresent()) {
            try {
                return doValidate(credential);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    private boolean doValidate(Credential credential) throws GeneralSecurityException {
        RSAKeyParameters rsaParameters = (RSAKeyParameters) keyStoreOpt.get().getKey("alias", "".toCharArray());
        Stream.of(certOpt.get().getCertificateChain())
            .map(cert -> (Certificate) cert)
            .forEach(cert -> CryptoUtils.addCertificateEntry(
                CryptoUtils.getKeyStoreCertificateEntry(
                    rsaParameters,
                    cert
                )
            ));

        return true;
    }

    private class CredentialAwareCallback implements Callback {
        private final CredentialValidator validator;

        public java_12305_CredentialValidator_A07(CredentialValidator validator) {
            this.validator = validator;
        }

        @Override
        public void passwordCallback(String password, String username, boolean isExpected, boolean isOldPassword)
            throws LoginException, UnsupportedCallbackException {
            validator.passwordCallback(password, username, isExpected, isOldPassword);
        }

        @Override
        public void status(String status) throws LoginException, UnsupportedCallbackException {
            validator.status(status);
        }
    }
}