import java.security.Credential;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_33928_CredentialValidator_A03 {
    public static void main(String[] args) {
        Validator validator = new Validator() {
            public PasswordAuthentication validate(Credential credential) {
                String password = (String) credential.getCredential();
                PasswordAuthentication authentication = null;

                if (password == null) {
                    throw new NullPointerException();
                } else {
                    authentication = AccessController.doPrivileged(new PrivilegedAction<PasswordAuthentication>() {
                        public PasswordAuthentication run() {
                            return new PasswordAuthentication(password, "");
                        }
                    });
                }

                return authentication;
            }
        };

        Credential credential = new Credential() {
            public String getName() {
                return "Test User";
            }

            public String getKind() {
                return "Password";
            }

            public String getCredential() {
                return "securepassword";
            }
        };

        PasswordAuthentication result = validator.validate(credential);
        System.out.println(result);
    }
}