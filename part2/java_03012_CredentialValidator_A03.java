import java.util.Arrays;
import java.util.List;

public class java_03012_CredentialValidator_A03 {
    private List<String> roles;

    public java_03012_CredentialValidator_A03(String... roles) {
        this.roles = Arrays.asList(roles);
    }

    public boolean isAuthorized(String userRole, String requestedRole) {
        return this.roles.contains(requestedRole) &&
                this.roles.contains(userRole);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("Admin", "User");

        String userRole = "User";
        String requestedRole = "Admin";

        if (validator.isAuthorized(userRole, requestedRole)) {
            System.out.println("User is authorized to perform this action.");
        } else {
            System.out.println("User is not authorized to perform this action.");
        }
    }
}