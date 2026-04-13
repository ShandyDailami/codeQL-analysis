import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.NotCompliantMBeanException;
import javax.management.remote.rmi.RMIConnection;

public class java_36751_CredentialValidator_A01 {

    private static final String SECRET = "mySecret";
    private static final String SALT = "mySalt";

    public boolean validate(String username, String password) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKey s = skf.generateSecret(new PBEKeySpec(password.toCharArray(), SALT.getBytes(), 1000, 256));

            String securePassword = Base64.getEncoder().encodeToString(s.getEncoded());

            return securePassword.equals(username);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user";
        String password = "password";

        if (validator.validate(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}