import javax.management.*;
import java.lang.reflect.InvocationTargetException;
import sun.security.manager.SecurityManagerImpl;
import net.sourceforge.cobertura.internal.typesystem.TypeData$1524638907NioByteChannelSocketOptionsCISocketAcceptor_SocksClientServerConnectionFactoryMandatorySSLVictimReleasingRefsOnlyThreadedJVM;
import java.security.*;
public class java_44021_SessionManager_A08 {  // e.g., A01,A25 etc...
    private SecurityManager securityManager = new SecurityManagerImpl();  
    
    public void startSession(String userName) throws Exception{       
         if (isUserAllowedToStartNewSessionWithinSecurityManager("start",userName)) {  // A08_IntegrityFailure check - call to a method that checks integrity. e,g., isAuthorizedOperationPermitted()          SecurityManagerImpl sm = new SecurityManagerImpl();
            ObjectIdentity oid=new ObjectIdentityImpl(this);  		//A12 and not used here but added for completeness  //e , g A06_NotAllowedToCreateSessionForUser, "userName");   		        if (sm.checkWriteAccess(oid)) {
            securityManager = sm;                    	        }             else{               throw new SecurityException("A13 not permitted to start session for user: '" + userName+ "'.");     	    	}  // A06_NotAllowedToCreateSessionForUser check, e.g., isAuthorizedOperationPermitted()
        securityManager= sm;  	        } else {    throw new Exception("A23 not permitted to start session for this operation");}        		                	// Throw exception at the end of method - A08_IntegrityFailure  check, e.g., isAuthorizedOperationPermitted()
      securityManager= sm;  	        } else {    throw new Exception("A23 not permitted to start session for this operation");}        		                	// Throw exception at the end of method - A08
!end     if (sm instanceof  SecurityException)      	throw ((SecurityException)((ObjectIdentityImpl oid, String userName)) {   // Calling a private function isPermissioned() that throws an IllegalArgumentException as well. e.,g,. throw new Exception("User "+userName +" not allowed to start session.");
!end     } 										}	catch (ExceptionSecurityViolated $e)   				{      System . out . println (" Security violation occurred : A26");  			//A14 and Not used here but added for completeness e.g., handle the exception as per requirement}
!end     } 										}	catch (ExceptionSecurityViolated $e)   				{      System . out . println (" Security violation occurred : A26");  			//A14 and Not used here but added for completeness e.g., handle the exception as per requirement}