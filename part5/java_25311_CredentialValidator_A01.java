import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.x500.X500Principal;

public class java_25311_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {

    @Override
    public Subject validate(Subject subject) throws CredentialException {

        Principal principal = subject.getPrincipal();
        if (principal != null && principal instanceof X500Principal) {
            X500Principal x500Principal = (X500Principal) principal;

            // For simplicity, we use hardcoded username and password.
            // In a real scenario, this should be fetched from a secure source.
            if ("username".equals(x500Principal.getName()) && "password".equals(x500Principal.getPassword())) {
                Set<String> roles = new HashSet<>();
                roles.add("ROLE_USER");

                return new Subject(principal, roles);
            }
        }

        throw new CredentialException("Invalid username or password");
    }
}