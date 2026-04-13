import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialAccess;
import java.security.credential.CredentialContext;
import java.security.credential.Name;
import java.util.HashSet;
import java.util.Set;

public class java_03688_CredentialValidator_A07 implements CredentialAccess {

    private String[] providerNames;
    private Set providers;

    public java_03688_CredentialValidator_A07(String[] providerNames) {
        this.providerNames = providerNames;
        this.providers = new HashSet();
        for (String providerName : providerNames) {
            try {
                Provider provider = Security.getProvider(providerName);
                this.providers.add(provider);
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

    }

    public boolean accessGranted(CredentialContext credentialContext, Name name) {
        return false;
    }

    public boolean accessGranted(CredentialContext credentialContext, Name name, String action) {
        return false;
    }

    public boolean accessGranted(CredentialContext credentialContext, Name name, String action, String attribute) {
        return false;
    }

    public Set getProviders() {
        return this.providers;
    }

    public CredentialAccess getAccess(Name name) {
        return this;
    }

    public CredentialAccess getAccess(Name name, String action) {
        return this;
    }

    public CredentialAccess getAccess(Name name, String action, String attribute) {
        return this;
    }
}