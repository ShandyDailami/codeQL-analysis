import java.security.InvalidParameterException;
import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.UsernamePasswordCredential;

public class java_29987_CredentialValidator_A01 {

    private static final Provider[] providers = Security.getProviders();

    public static void main(String[] args) {
        System.out.println("Providers: ");
        for (Provider provider : providers) {
            System.out.println("  " + provider.getName());
        }

        String providerName = "MyProvider";
        System.out.println("Registering provider " + providerName);
        Security.addProvider(new MyCredentialProvider(providerName));

        Credential credential = getCredential("user", "password");
        validate(credential);
    }

    private static Credential getCredential(String user, String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
        return new UsernamePasswordCredential(user, password.toCharArray());
    }

    private static void validate(Credential credential) {
        try {
            credential.validate();
            System.out.println("Credential is valid");
        } catch (Exception e) {
            System.out.println("Credential is not valid: " + e.getMessage());
        }
    }

    static class MyCredentialProvider extends CredentialProvider {

        private String providerName;

        public java_29987_CredentialValidator_A01(String providerName) {
            this.providerName = providerName;
        }

        public String getProviderName() {
            return providerName;
        }

        public Credential newCredential(String type) {
            if ("UsernamePasswordCredential".equals(type)) {
                return new UsernamePasswordCredential();
            }
            throw new UnsupportedOperationException("Unsupported credential type: " + type);
        }

        public boolean isUsesApplicationPolicy() {
            return true;
        }

        public boolean isUsesDefaultPolicy() {
            return true;
        }
    }
}