import java.security.InvalidParameterException;
import java.security.Provider;
import java.security.Security;
import java.util.HashSet;
import java.util.Set;

public class java_31289_CredentialValidator_A01 {

    private static final String USERNAME_ATTRIBUTE = "username";
    private static final String PASSWORD_ATTRIBUTE = "password";

    private static final Set<String> ALLOWED_USERNAMES = new HashSet<>();
    static {
        ALLOWED_USERNAMES.add("admin");
        ALLOWED_USERNAMES.add("user1");
        ALLOWED_USERNAMES.add("user2");
    }

    public static Provider createProvider() {
        return new Provider("CustomCredentialValidator") {
            @Override
            public Set<String> getSupportedAlgorithms() {
                return new HashSet<>();
            }

            @Override
            public String getDescription() {
                return "A custom credential validator";
            }
        };
    }

    public static Credential validator(String username, String password) throws InvalidParameterException {
        if (!ALLOWED_USERNAMES.contains(username) || !password.equals("securePassword")) {
            throw new InvalidParameterException("Invalid username or password");
        }

        return new Credential() {
            @Override
            public String getId() {
                return "CustomCredentialValidator";
            }

            @Override
            public String getName() {
                return "Custom Credential Validator";
            }

            @Override
            public String getTranslations(String property) throws IllegalArgumentException {
                switch (property) {
                    case "name":
                        return getName();
                    case "id":
                        return getId();
                    default:
                        throw new IllegalArgumentException("Property " + property + " not supported by " + getClass().getName());
                }
            }

            @Override
            public String getTranslations(Set<String> properties) throws IllegalArgumentException {
                return getTranslations(properties.toArray(new String[properties.size()])[0]);
            }

            @Override
            public Set<String> getSupportedCredentialIdentifiers() {
                return new HashSet<>();
            }

            @Override
            public boolean supports(String identifier) {
                return false;
            }

            @Override
            public boolean validate(CredentialContext context) throws CredentialValidationException {
                return true;
            }

            @Override
            public boolean isNormalized() {
                return false;
            }

            @Override
            public String getNormalizedForm(CredentialContext context) throws CredentialValidationException {
                return null;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return obj.equals(this);
            }

            @Override
            public int hashCode() {
                return getClass().hashCode();
            }
        };
    }
}