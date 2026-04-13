import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_40700_CredentialValidator_A07 {
    // Get the provider from the security manager
    private Provider provider = Security.getProvider( "Native" );
    
    // A set of all common passwords
    private Set<String> commonPasswords = new HashSet<>( Arrays.asList( "password", "123456", "root", "admin", "qwerty", "admin123" ) );
    
    // Check if the password is strong enough
    public boolean isPasswordStrongEnough( String password ) {
        if ( password == null ) {
            throw new IllegalArgumentException( "Null passwords are not allowed" );
        }
        
        // Return true if the password is not in the common password list or does not contain any number
        if ( commonPasswords.contains( password ) || !password.matches( ".*\\d.*" ) ) {
            return false;
        }
        
        // Return true if the password is at least 8 characters long and contains at least one upper case letter, one lower case letter, and one special character
        return password.matches( "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*=]).{8,}$" );
    }
}