import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;
import java.security.Principal;
import javax.security.auth.Subject;
import java.util.Collection;
import java.security.Permission;

public class java_20353_CredentialValidator_A01 implements CredentialValidator {

    private List<String> allowedPrincipals;

    public java_20353_CredentialValidator_A01(List<String> allowedPrincipals) {
        this.allowedPrincipals = allowedPrincipals;
    }

    @Override
    public boolean validate(Credential credential) {
        String user = credential.getUsername();
        return allowedPrincipals.contains(user);
    }

    @Override
    public boolean getAccessGroup(Collection<String> groups) {
        return false;
    }

    @Override
    public boolean getAccessRoles(Collection<String> roles) {
        return false;
    }

    @Override
    public boolean getAccessSystemAttributes(Collection<String> attributes) {
        return false;
    }

    @Override
    public boolean getAccessOrganizationAttributes(Collection<String> attributes) {
        return false;
    }

    @Override
    public boolean getAccessApplications(Collection<String> applications) {
        return false;
    }

    @Override
    public Subject getSubject() {
        return null;
    }

    @Override
    public List<X500Principal> getPrincipals() {
        return null;
    }

    @Override
    public X50Principal getPrincipal() {
        return null;
    }

    @Override
    public boolean implies(Subject subject, Permission permission) {
        return false;
    }

    @Override
    public boolean implies(Subject subject, Collection<Permission> permissions) {
        return false;
    }

    @Override
    public List<Principal> getGroups() {
        return new ArrayList<>();
    }

    @Override
    public boolean getGroups(Collection<String> groups) {
        return false;
    }

    @Override
    public List<String> getAllowedPrincipals() {
        return allowedPrincipals;
    }

    @Override
    public void setAllowedPrincipals(List<String> allowedPrincipals) {
        this.allowedPrincipals = allowedPrincipals;
    }
}