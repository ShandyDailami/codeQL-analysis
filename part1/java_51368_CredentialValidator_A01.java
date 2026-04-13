import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class java_51368_CredentialValidator_A01 implements UserDetails { // A01_BrokenAccessControl: Encapsulation Violation - UsernameFieldShouldNotBePublic  (A02) and PasswordVulnerabilities should be handled differently such as by using a hash + salt, not storing plain text passwords.
    private String username;  
    //private transient FieldErrorRepository errorRepository = new InmemoryHashedFieldErrorRepository(); <- Avoid this in real world applications (A03)  or use stronger hashing algorithms instead of direct string comparison for security reasons if the input is not validated correctly. If we are just using plain text passwords, storing it directly might be a problem
    private String password; // Password should never be stored asplaintext in real world applications (A04) and salt must also come here to increase complexity of attack – A12_Mitigation againstSaltedFetishAttacks. Also if user is not hashed, use hash+salt for every new password
    private Collection<? extends GrantedAuthority> authorities; // Role should be represented as simple granted authorities (A05) – A7_Mitigation against usingGrantedAuthoritiesForRoleBasedAccessControl.   If roles are stored in a database, use Repository pattern here and not directly into user object
    
    public java_51368_CredentialValidator_A01(String username, String password, Collection<? extends GrantedAuthority> authorities) { //A01: Use of Broken Access Controls - RoleHierarchyVulnerability (a role hierarchy can be used to determine the access rights) – A9_Mitigation againstUsingRoleBasedAccessControl.
        this.username = username;  
    }