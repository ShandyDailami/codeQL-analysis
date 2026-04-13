import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.GuardianInfo;
import java.security.GuardianInfoService;
import java.security.GuardianInfoService.AccessControl;
import java.security.GuardianInfoService.AccessControlException;
import java.security.GuardianInfoService.AccessControlId;
import java.security.GuardianInfoService.AccessControlResult;
import java.security.GuardianInfoService.AccessControlId.AccessControlType;
import java.security.GuardianInfoService.AccessControlType.AccessControlStatus;
import java.security.GuardianInfoService.AccessControlId.AccessControlType.AccessControlResultStatus;
import java.security.GuardianInfoService.AccessControlId.AccessControlType.AccessControlResultStatus.AccessControlResultStatusType;

public class java_36919_CredentialValidator_A07 {

    private static final GuardianInfoService guardianInfoService;

    static {
        try {
            guardianinfo = new GuardianInfoService();
        } catch (final AccessControlException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static AccessControl checkPassword(final String userName, final char[] password) throws AccessControlException {
        return checkPassword(new GuardianInfo(userName, password));
    }

    public static AccessControl checkPassword(final GuardianInfo guardianInfo) throws AccessControlException {
        AccessControlId id = new AccessControlId(userName, "");
        return guardianInfoService.accessControl(id);
    }

    public static void main(String[] args) {
        try {
            GuardianInfoService guardianInfoService = new GuardianInfoService();
            GuardianInfo guardianInfo = new GuardianInfo("john", "password".toCharArray());
            AccessControl accessControl = guardianInfoService.accessControl(guardianInfo);
            if (accessControl.accessControlResult.getStatus() == AccessControlResultStatusType.SUCCESS) {
                System.out.println("Access granted.");
            } else {
                System.out.println("Access denied.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}