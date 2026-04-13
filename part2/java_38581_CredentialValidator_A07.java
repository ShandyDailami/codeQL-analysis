import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBroker;
import java.util.HashSet;
import java.util.Set;

public class java_38581_CredentialValidator_A07 {

    public static void main(String[] args) {
        Set<Provider> providers = new HashSet<>();
        providers.add(new MyProvider());
        Security.addProvider(new MyProvider());

        CredentialProviderBroker broker = CredentialProviderBroker.getDefaultBroker();
        broker.setProviders(providers);

        Credential credential = broker.get("username", "password".toCharArray());
        if (credential != null) {
            System.out.println("Successfully validated credentials");
        } else {
            System.out.println("Failed to validate credentials");
        }
    }

    private static class MyProvider extends Provider {
        private static final String MY_NAME = "MyProvider";

        MyProvider() {
            super(MY_NAME, MY_NAME, "1.0", Configuration.getJavaProperties());
        }

        @Override
        public String getName() {
            return MY_NAME;
        }

        @Override
        public Set<Class<?>> getClasses() {
            Set<Class<?>> classes = new HashSet<>();
            classes.add(MyCredential.class);
            return classes;
        }
    }

    private static class MyCredential implements Credential {
        private final char[] password;

        MyCredential(char[] password) {
            this.password = password;
        }

        @Override
        public char[] getPassword() {
            return password;
        }

        @Override
        public String getId() {
            return "username";
        }
    }
}