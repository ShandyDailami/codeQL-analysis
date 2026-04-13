// CredentialValidator is a class java_09298_CredentialValidator_A01 one method validate which is used for validating a username and password.
public class CredentialValidator {
    // validate method to validate username and password.
    public boolean validate(String username, String password) {
        // For simplicity, let's say if the username is 'admin' and password is 'password' we return true.
        // In a real-world application, we would typically use a database or some other form of persistent storage to check these credentials.
        return username.equals("admin") && password.equals("password");
    }
}

// UserDetailsService is a class with one method loadUserByUsername which is used for fetching user details.
public class UserDetailsService {
    // loadUserByUsername method to load user details.
    public UserDetails loadUserByUsername(String username) {
        // For simplicity, let's say we have a user with username 'admin' and password 'password'.
        // In a real-world application, we would typically return a UserDetails object with these user details.
        return new User(username, "password", true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}

// SecurityConfiguration is a class with one method configure which is used for configuring security settings.
public class SecurityConfiguration {
    // configure method to configure security settings.
    public void configure(HttpSecurity http) throws Exception {
        // In a real-world application, you would typically use a form login to allow users to log in.
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().and()
                .logout().permitAll();
    }
}

// Main class to test the above classes.
public class Main {
    public static void main(String[] args) {
        // Create instances of CredentialValidator, UserDetailsService and SecurityConfiguration.
        CredentialValidator credentialValidator = new CredentialValidator();
        UserDetailsService userDetailsService = new UserDetailsService();
        SecurityConfiguration securityConfiguration = new SecurityConfiguration();

        // Use these instances to test the security features.
        boolean isValid = credentialValidator.validate(userDetailsService.loadUserByUsername("admin").getUsername(), "password");

        // Print the result.
        System.out.println("Is valid: " + isValid);
    }
}