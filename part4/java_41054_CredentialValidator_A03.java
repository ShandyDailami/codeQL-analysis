import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBroker;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

public class java_41054_CredentialValidator_A03 {

    public static void main(String[] args) {
        // Get a provider
        Provider provider = Security.getProvider("MyProvider");
        if (provider == null) {
            System.out.println("No provider named 'MyProvider'.");
            return;
        }

        // Get a credential provider
        CredentialProvider cp = (CredentialProvider) provider.getCredentialProvider(new java.security.PrivateCredential.Delegate("User1"));
        if (cp == null) {
            System.out.println("No credential provider named 'User1'.");
            return;
        }

        // Create a credential
        KeySpec ks = new org.ietf.jgss.kerberos.KerberosKeySpec("user@EXAMPLE.COM", "MY_KEY");
        AlgorithmParameterSpec aps = new org.ietf.jgss.kerberos.KerberosParametersSpec(ks);
        Credential cred = cp.getCredential(new java.security.PrivateCredential.Delegate("User1"), new java.security.PrivateCredential.Delegate(aps));

        // Validate the credential
        if (cred != null) {
            System.out.println("Credential is valid.");
        } else {
            System.out.println("Credential is not valid.");
        }
    }
}