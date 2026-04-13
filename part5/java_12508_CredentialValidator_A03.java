import javax.security.auth.Credential;
import javax.security.auth.Subject;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.GuaranteedAccessException;

public class java_12508_CredentialValidator_A03 implements CredentialValidator {

    private final AccessControl accessControl;

    public java_12508_CredentialValidator_A03(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        Subject subject = new Subject(accessControl.getParticipants());

        try {
            accessControl.checkPermission(subject, credential);
        } catch (GuaranteedAccessException e) {
            return new CredentialValidationResult("Access denied");
        } catch (Exception e) {
            return new CredentialValidationResult("Error occurred while checking access permission");
        }

        return new CredentialValidationResult("Access granted");
    }

    public static void main(String[] args) {
        // This is a simple test, in reality, you would use a more sophisticated access control mechanism
        AccessControl accessControl = new AccessControl() {
            @Override
            public String[] getParticipants() {
                return new String[] {"User"};
            }

            @Override
            public void checkPermission(Subject subject, Object permission) throws GuaranteedAccessException {
                if (!(permission instanceof String)) {
                    throw new IllegalArgumentException();
                }

                String permissionName = (String) permission;

                if (permissionName.equals("read")) {
                    subject.getPrincipals().iterator().next().getClass().newInstance();
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        };

        LegacyCredentialValidator validator = new LegacyCredentialValidator(accessControl);
        CredentialValidationResult result = validator.validate(null);
        System.out.println(result.getResultMessage());
    }
}