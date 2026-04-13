import java.security.*;

public class java_29136_CredentialValidator_A03 {
    public static boolean validateCredentials(String username, String password) {
        // The username and password are not secure because they are sent directly to the system
        // without any protection. To ensure their security, it's recommended to store hashed versions of them.
        // But, for simplicity, we're going to use the same password and username for demonstration.

        // Create a new security manager
        SecurityManager sm = new SecurityManager() {
            @Override
            public boolean checkHost(String host) {
                return true;
            }

            @Override
            public boolean checkUser(String user) {
                return true;
            }
        };

        // Use the security manager to validate the credentials
        try {
            sm.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    // Here you could use your own logic for comparing the passwords.
                    // For example, you could hash the input password and compare it to the stored hash.
                    // But for simplicity, we'll just compare the plaintext version.

                    if (username.equals("admin") && password.equals("password")) {
                        return null;
                    } else {
                        throw new AccessControlException("Access denied.");
                    }
                }
            });
            return true;
        } catch (AccessControlException ace) {
            System.out.println("Access denied: " + ace.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        validateCredentials("admin", "password");
    }
}