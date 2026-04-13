import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
@Service("customUserDetailsService")  // Define the bean name for Spring to use this class java_42268_CredentialValidator_A07 an AuthenticationProvider service (A06_AuthProv)
public class CustomUserDetailService implements UserDetailsService {   //Define interface with methods needed by spring security( A12 - SecurityConfig ) that we will implement.    The method hashes and encrypts the password given in login, to check against stored data  (A07_AuthFailure)
                                                                       if it matches then return UserDetails object of user information otherwise exception occurs     //Define interface with methods needed by spring security( A12 - SecurityConfig ) that we will implement.    The method hashes and encrypts the password given in login, to check against stored data  (A07