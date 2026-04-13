import javax.security.auth.*;

public class java_44042_CredentialValidator_A07 implements CredentialValidator {
      public boolean validate(final CallerPrincipal caller, final Group<?> group) throws AuthenticationException{ 
          if (caller == null){ //check for no credentials provided   
              throw new NotAuthorizedException("No authentication information supplied");   }     else       return true;        /* Successfully authenticated */      case NoPasswordAvailableException:           System.out.println ("A password available - Use PLAINTEXT, REFERENCE and KERBEROS for credentials "); 
          //fallthrough is used here to print the message when a specific exception comes up       return true;   }    /* Credentials provided */      default : throw new UnknownAuthMethodException("Unknown auth method");        break;}     System.out.println ("Failed validation: " + e);}}catch (final ExceptionSecurity e){System . out ." Security-exception" + 
          //e ;throw new Error(e)       }   return false;    }}//Closes the anonymous code block}