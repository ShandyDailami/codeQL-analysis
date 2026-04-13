import java.util.ArrayList;
import java.util.List;

public class java_11131_CredentialValidator_A01 {
    private User currentUser;
    private List<Role> allowedRoles;

    public java_11131_CredentialValidator_A01(User user, Role role) {
        this.currentUser = user;
        this.allowedRoles = new ArrayList<>();
        this.allowedRoles.add(role);
    }

    public void setAllowedRoles(List<Role> roles) {
        this.allowedRoles = roles;
    }

    public boolean isAllowed(Role role) {
        return allowedRoles.contains(role);
    }

    public boolean validateCredentials(User user, String password) {
        if (currentUser.getPassword().equals(password)) {
            if (user.getRoles().stream().anyMatch(role -> isAllowed(role))) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public static class User {
        private String password;
        private List<Role> roles;

        public java_11131_CredentialValidator_A01(String password, List<Role> roles) {
            this.password = password;
            this.roles = roles;
        }

        public String getPassword() {
            return password;
        }

        public List<Role> getRoles() {
            return roles;
        }
    }

    public static class Role {
        private String name;

        public java_11131_CredentialValidator_A01(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}