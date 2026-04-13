import javax.security.auth.*;
import java.util.Arrays;
import java.util.Base64;

public class java_45219_CredentialValidator_A07 implements Authenticator {
    private static final String USER = "user";  // Actual username for the user 'test' and password is encoded as Base64('password') in plain text - DO NOT USE THIS IN A REAL-WORLD APP.
    private static final String PASSWORD = new String(Base64.getDecoder().decode("Y2hhbGzC5uGSyZjF"));  // Actual password for the user 'test' and encoded in plain text - DO NOT USE THIS IN A REAL-WORLD APP.
    
    public AuthenticatorResult authenticate(AuthenticatorInformation info) throws AuthenticationException {  
        String presentedPassword = new String (Base64.getDecoder().decode((String)info.getCredential()));  // Password received from the client, decoded in plain text - DO NOT USE THIS IN A REAL-WORLD APP.   
        
        if(Arrays.equals(presentedPassword(), PASSWORD)) {   /* Checking whether entered password matches with predefined one */  // Actual comparison logic for authentication, could be any complex rule using user details received from client or stored in DB etc - DO NOT USE THIS IN A REAL-WORLD APP.
            return new AuthenticatorResult.Success(info);   /* If passwords match we get a successful result */  // Actual implementation here is not used for this example as it's quite basic, but to show the logic of authentication - DO NOT USE THIS IN A REAL-WORLD APP
        } else {    /* Else there was an error in presenting password (e.g: incorrect format) */  // Actual implementation here is not used for this example as it's quite basic, but to show the logic of authentication - DO NOT USE THIS IN A REAL-WORLD APP
            return new AuthenticatorResult.Fail(info, "Invalid Credentials");   /* We fail with an error message */  // Actual implementation here is not used for this example as it's quite basic, but to show the logic of authentication - DO NOT USE THIS IN A REAL-WORLD APP
        }   
         return null;     /**/      AuthenticatorResult.Indeterminate       /* Failure type that doesn’t provide more information */  // Actual implementation here is not used for this example as it's quite basic, but to show the logic of authentication - DO NOT USE THIS IN A REAL-WORLD APP
    }   /**/     };        Authenticator      /* End anonymous inner class definition. This needs a name */  // Actual implementation here is not used for this example as it's quite basic, but to show the logic of authentication - DO NOT USE THIS IN A REAL-WORLD APP
}   /**/     };        CredentialValidator;    /* End anonymous inner class definition. This needs a name */  // Actual implementation here is not used for this example as it's quite basic, but to show the logic of authentication - DO NOT USE THIS IN A REAL-WORLD APP