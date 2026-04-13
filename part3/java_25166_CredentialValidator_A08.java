import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialAccess;
import java.security.credential.UsernamePasswordCredentials;
import java.util.concurrent.atomic.AtomicBoolean;

public class java_25166_CredentialValidator_A08 {

    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            printProviderInfo(provider);
            try {
                validateCredentials(provider);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void printProviderInfo(Provider provider) {
        System.out.println("Provider: " + provider.getName());
        System.out.println("Version: " + provider.getVersion());
        System.out.println("Vendor: " + provider.getInfo());
    }

    private static void validateCredentials(Provider provider) throws Exception {
        Credential credential = (Credential) provider.getCredential(null);
        if (credential == null) {
            System.out.println("No credential available");
            return;
        }

        AtomicBoolean success = new AtomicBoolean(false);
        credential.validate(new CredentialAccess() {
            @Override
            public void validate(Credential cred) throws Exception {
                UsernamePasswordCredentials upCred = (UsernamePasswordCredentials) cred;
                if (upCred.getUsername().equals("wrongUserName") && upCred.getPassword().equals("wrongPassword")) {
                    System.out.println("Integrity failure detected. Password is incorrect");
                    throw new Exception("Integrity failure");
                }
                success.set(true);
            }
        });

        if (!success.get()) {
            System.out.println("No integrity failure detected. Password is correct");
        }
    }
}