import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.modes.CipherBlockMode;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.GCMParameterSpec;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.tls.CipherCredentials;
import org.bouncycastle.crypto.tls.Credential;
import org.bouncycastle.crypto.tls.HashAlgorithm;
import org.bouncycastle.crypto.tls.IdentityProof;
import org.bouncycastle.crypto.tls.SignedCertificateTimestamp;
import org.bouncycastle.crypto.tls.TlsCredential;
import org.bouncycastle.crypto.tls.TlsEncryptedExtensions;
import org.bouncycastle.crypto.tls.TlsVersions;
import org.bouncycastle.crypto.util.CryptoUtils;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class java_16822_CredentialValidator_A03 {

    private static final String PASSWORD = "password";
    private static final String USER_NAME = "username";
    private static final int KEY_SIZE = 256;
    private static final int TLS_VERSION = TlsVersions.TLS_1_2;
    private static final List<Integer> AUTH_PROTOCOLS = new ArrayList<>();
    private static final List<IdentityProof> IDENTITY_PROOF = new ArrayList<>();
    private static final List<HashAlgorithm> SUPPORTED_HASHES = new ArrayList<>();
    private static final String PROOF_NAME = "SAS";

    static {
        AUTH_PROTOCOLS.add(4);
        IDENTITY_PROOF.add(IdentityProof.of(PROOF_NAME, Credential.decrypt(USER_NAME)));
        SUPPORTED_HASHES.add(HashAlgorithm.SHA256);
    }

    public java_16822_CredentialValidator_A03() {
    }

    public void validate(Credential credential) {
        try {
            authenticate(credential);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void authenticate(Credential credential) throws IOException {
        PemReader pemReader = new PemReader(new FileReader("certificate.pem"));
        PemObject pemObject = pemReader.readPemObject();
        SignedCertificateTimestamp timestamp = SignedCertificateTimestamp.parse(pemObject.getContent());
        pemReader.close();

        CipherBlockMode cipherBlockMode = new GCMBlockCipher(timestamp.getCertificate().getPublicKey().getAlgorithmParameters());
        cipherBlockMode.init(true, new AEADParameters(new KeyParameter(cryptoUtils.generateKey(KEY_SIZE)), new SecureRandom(), null, timestamp.getCertificate()));
        byte[] encryptedData = timestamp.getCertificate().getSignature(HashAlgorithm.SHA256, USER_NAME, PASSWORD, AUTH_PROTOCOLS, IDENTITY_PROOF, SUPPORTED_HASHES, TLS_VERSION);
        byte[] decryptedData = cipherBlockMode.doFinal(encryptedData);

        if (!Arrays.equals(decryptedData, timestamp.getCertificate().getSignature(HashAlgorithm.SHA256, USER_NAME, PASSWORD, AUTH_PROTOCOLS, IDENTITY_PROOF, SUPPORTED_HASHES, TLS_VERSION))) {
            throw new InvalidCipherTextException("Invalid signature");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate(CryptoUtils.generateRandomKey(KEY_SIZE));
    }
}