import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration  // Spring Java Config annotation, makes this class java_48062_SessionManager_A07 source of bean definitions for the application context.
public class SecurityConfig {   // Inherit from WebSecurityConfigurerAdapter if you need to implement authentication provider and authorization service in your configuration (e.g., custom login page). It is not needed here as we are just using Spring security's built-in features only – user details, password encryption etc
    @Bean   // Defines a bean for the UserDetailsService that can provide users by their username and load them from an in memory list of Users. This service would typically work with JdbcTemplate or any other data source which provides access to stored information (e.g., via hibernate). It's used when we want Spring Security Authentication Provider for our UserDetailsService
    public UserDetailsService userDetailsService() {   // Override this method and provide a custom implementation if needed, like using JdbcTemplate or any other data source to retrieve users from your database. This service would typically work with Hibernate ORM in the following way: select * FROM Users WHERE username = ?
        return new InMemoryUserDetailsManager(   // Create an instance of this class which wraps around User and Role interfaces (implemented by DefaultUserDetails) for storing users information. Spring Security will use these to get user data on demand, providing you with the ability handle authentication via your custom database or a third-party source like LDAP
            new SimpleGrantedAuthority( "ROLE_USER" )  // Grants this Role attribute (accessing /user) and accesses User's attributes from our userDetailsService. Here we are just storing it as an in memory list of users, for the purpose here since no database was used
        );   }   
    
@Bean("authenticationManager")  // Defines a bean to provide Authenticator which can handle authentication request and validate credentials (e.g., by checking against user name & password). Spring Security’s built-in features only work with JDBC or other data source if you are using it in your configuration
public AuthenticationProvider authenticationProvider() {   // Override this method to provide a custom implementation of the UserDetailsService and RoleHierarchy service. Here we use default ones, but Spring Security provides them as well (injectable).  This allows us with our new user details provider for auth failures handling
    return new DaoAuthenticationProvider()   // Create an instance if this class which wraps around Authentication Provider interfaces to handle authentication and validate the credentials. The implementation is provided by DefaultUserDetailsAuthenticationProvider or any other data source that provides implementations of these methods (e.g., JdbcDaoImpl)
        .setPasswordEncoder(new BCryptPasswordEncoder());  // Sets a password encoder which will be used to encode/decode the user's credentials and also verify them against stored hashes in your database when validating authentication requests or access tokens, using Spring Security’s default implementation of this. (e.g., new BCryptPasswordEncoder())
        .setUserDetailsService(userDetailsService());  // Sets a User Details service which can provide users by their username and load them from an in memory list of Users when performing authentication requests or access tokens, using Spring Security’s default implementation: InMemoryUserDetailsManager.getInstance().loadUsersByUsernameFromSource()
    );   }    
}