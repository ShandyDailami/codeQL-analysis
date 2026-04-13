import javax.management.InstanceAlreadyExistsException;
import javax.management.InvalidCredentialIdException;
import javax.management.ReferenceNotFoundException;
import javax.management.CredentialNotFoundException;
import javax.management.AuthenticationFailedException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.security.auth.login.CredentialException;

public class java_28115_CredentialValidator_A01 {

    public static void main(String[] args) throws MalformedObjectNameException, CredentialException, MBeanException,
            AuthenticationFailedException, CredentialNotFoundException, ReferenceNotFoundException, InstanceAlreadyExistsException,
            InvalidCredentialIdException {

        // Create MBeanServer
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Create object name
        ObjectName name = new ObjectName("com.example.CredentialValidator:type=ValidationRule");

        // Create CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Register MBean
        mbs.registerMBean(validator, name);

        // Start validating
        validate(validator);

        // Unregister MBean
        mbs.unregisterMBean(name);
    }

    public void validate(CredentialValidator validator) throws CredentialException {
        // Use CredentialValidator to validate password
        if (validator.validate("Password@123")) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}

class CredentialValidator implements javax.security.auth.CredentialValidator {

    @Override
    public boolean validate(javax.security.auth.credential.Credential cred) throws CredentialException {
        String password = cred.getPassword().toString();

        boolean containsDigit = password.matches(".*\\d.*");
        boolean containsUpperCase = password.matches(".*[A-Z].*");
        boolean containsLowerCase = password.matches(".*[a-z].*");
        boolean containsSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        return containsDigit && containsUpperCase && containsLowerCase && containsSpecialChar;
    }
}