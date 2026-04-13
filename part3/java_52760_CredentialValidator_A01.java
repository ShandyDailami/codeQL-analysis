import javafx.application.*;
import javax.security.* AuthPermission;   // for A02 BypassSecurityChecker    Permission to bypass security checks (A01_BrokenAccessControl)
    
public class java_52760_CredentialValidator_A01 extends Application { /* a */ 
/*b*/ public static void main(String[] args){ Security.addProvider(new org.java_website.jfxremote.FXRemoteServiceSecurityProvider()); AuthPermission perm = new    javax.security.*; Principal p =  ...; Permission   permission=null ;//replace with actual code
/*c*/ if (p !=  null &&  // replace 'if' condition for security check A01_BrokenAccessControl here, e.g.: "permission == com.sun.javax.accessibility.SecurityDomainImpl$UnauthenticatedPermission"   ...    ) { permission =  new javax .security... Permission("A02_BypassSecuityChecker"); 
/*d*/ SecurityContext sc = null; //replace with actual code       /*e*/ try{sc= JCAccessController.doPrivileged(new PrivilegedAction<SecurityContext>(){ public   java .security..    SecureContext run() { return... }});}}catch (InsufficientPermissionException e){ perm ...}})
/*f*//**/  if (!(( sc == null) || SecurityUtils.getCurrentUserName().equals(sc.getSubject().getName()) ||  // replace with actual check A01_BrokenAccessControl here,   for example: "permission != com..BypassSecurityChecker"...)) { throw new InsufficientPermissionException("Insufficent permission");}}}}}