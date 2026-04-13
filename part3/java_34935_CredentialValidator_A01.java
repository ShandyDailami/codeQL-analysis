import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class java_34935_CredentialValidator_A01 {

    private UserDetailsService userDetailsService;
    private ShaPasswordEncoder passwordEncoder;

    public java_34935_CredentialValidator_A01(UserDetailsService userDetailsService, ShaPasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean validateCredentials(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        boolean credentialsMatch = passwordEncoder.isPasswordValid(userDetails, password, null);

        if (credentialsMatch) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        return credentialsMatch;
    }
}