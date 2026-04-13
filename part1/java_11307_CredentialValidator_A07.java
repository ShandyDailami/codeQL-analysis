import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderSpi;

public class java_11307_CredentialValidator_A07 extends CredentialProviderSpi {

    private String password;

    public java_11307_CredentialValidator_A07(String password) {
        this.password = password;
    }

    @Override
    public Provider getProvider() {
        return Security.getProvider("MyCredentialProvider");
    }

    @Override
    public Credential newCredential(String type, String provider) {
        if ("Credential".equals(type) && "MyCredentialProvider".equals(provider)) {
            return new CustomCredential();
        }
        return null;
    }

    private class CustomCredential implements Credential {

        @Override
        public String getCredentialType() {
            return "Credential";
        }

        @Override
        public String getCredentialIdentifier() {
            return "MyCredentialIdentifier";
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public void setPassword(String password) {
            // Do nothing, we only return the current password
        }
    }
}