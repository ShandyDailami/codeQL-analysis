import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardianInfo;
import java.security.GuardianInfoService;
import java.security.Permission;
import java.security.Policy;
import java.util.ArrayList;
import java.util.List;

public class java_13844_CredentialValidator_A01 {

    private List<String> patterns;
    private AccessControl accessControl;

    public java_13844_CredentialValidator_A01() {
        this.patterns = new ArrayList<>();
        this.accessControl = new AccessControlContext();
        try {
            GuardianInfoService guardianInfoService = (GuardianInfoService) Class.forName("java.security.GuardianInfoService").getDeclaredConstructor().newInstance();
            GuardianInfo guardianInfo = guardianInfoService.getGuardianInfo(this.getClass().getClassLoader());
            this.accessControl.getGuardian(guardianInfo);
        } catch (Exception e) {
            // Handle exception
        }
    }

    public void addPattern(String pattern) {
        this.patterns.add(pattern);
    }

    public boolean validate(String password) throws AccessDeniedException {
        for (String pattern : this.patterns) {
            if (password.matches(pattern)) {
                this.accessControl.checkPermission(new Permission("view"));
                return true;
            }
        }
        throw new AccessDeniedException("Access Denied");
    }
}