import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.RemoteException;

public class java_02398_CredentialValidator_A08 implements CredentialValidator {
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int iterations = 1000;
    private static final String salt = "salt";

    public boolean validate(String password) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            SecretKey secretKey = secretKeyFactory.createKey(getSalt());
            byte[] hashPassword = secretKey.getEncoded();

            SecretKeyFactory secretKeyFactoryCheck = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] checkPassword = secretKeyFactoryCheck.generateKey(password).getEncoded();

            int diff = (hashPassword.length ^ checkPassword.length) + (hashPassword[hashPassword.length - 1] ^ checkPassword[checkPassword.length - 1]);

            for (int i = 0; i < hashPassword.length && i < checkPassword.length; i++) {
                diff |= (hashPassword[i] ^ checkPassword[i]);
            }

            return diff == 0;
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
        }

        return false;
    }

    private String getSalt() {
        return salt;
    }

    public static void main(String[] args) {
        PasswordChecker checker = new PasswordChecker();
        System.out.println(checker.validate("password"));
    }
}