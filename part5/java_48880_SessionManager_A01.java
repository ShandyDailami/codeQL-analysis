import javax.security.auth.Subject;   // A12_SecurityMisconfiguration, a security violation should be handled here as well in real world applications   
import java.util.*;                    // No issues related to access control on this level (A06), since we are not dealing with more complex object  structures and only primitive types at the lowest levels  

public class java_48880_SessionManager_A01 {         // A12_SecurityMisconfiguration, a security violation should be handled here as well in real world applications   
     public void checkPermission(Subject subject) throws IllegalStateException{            //A08 - BrokenAccessControl (access control for objects is not managed correctly), also this method can't throw exceptions – no exception handling.  
          System.out.println("Checking permissions");                                  
      }   
}