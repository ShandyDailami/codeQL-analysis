import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBroker;
import java.security.credential.Credentials;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

public class java_18472_CredentialValidator_A08 {

    public static void main(String[] args) {
        // Obtain a security provider
        Provider provider = Security.getProvider("SunJCE");

        // Obtain a credential provider
        CredentialProviderBroker broker = (CredentialProviderBroker) provider.getService("CredentialProviderBroker");

        // Create a credential provider
        CredentialProvider credProvider = broker.createCredentialProvider(new KeySpec[] {
                (KeySpec) new org.bouncycastle.crypto.params.DSAPrivateKeyParameters(org.bouncycastle.crypto.params.DSAPrivateKeyParameters.create("123456781234567812345678"))
        }, new AlgorithmParameterSpec[] {}, new org.bouncycastle.crypto.params.DSAParameters(org.bouncycastle.crypto.params.DSAParameters.create("123456781234567812345678", 1024, 1024, 256, 13)),
                "SunJCE", "SunJCE", null);

        // Create a credential
        Credential credential = credProvider.createCredential("username", "password".toCharArray());

        // Validate the credential
        boolean valid = broker.validate(new Credentials[] { credential }, "SunJCE");

        System.out.println("Credential is " + (valid ? "valid" : "invalid"));
    }
}