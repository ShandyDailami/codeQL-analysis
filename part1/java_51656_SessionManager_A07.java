import java.util.*;
  
public class java_51656_SessionManager_A07 {    // UserModel Class if needed)       
  public String name;      // Name attribute (assuming each user has unique names...)        
}    
      
class SecurityManagerImpl extends AbstractSecurityManager{         
 private Map<String, List<Action>> mapAccess;          
  
public java_51656_SessionManager_A07() {           
    this.mapAccess = new HashMap<>();              // initialize our session storage (Hash Maps are good for lookups...         }             public void addSession(User user)        {}          ... and we'll start with a hard coded list of actions      private List<Action> sampleActions;  
    this.sampleActions = Arrays.asList("read", "write");  // initialize our available operations       };     @Override protected boolean sameThreadSameSession(SecurityContext current, Object object) {        return true;}          ... and by default we consider the session to be in a thread on which it's run     
    }public void setSampleActions (List<Action> sampleactions){            this.sampleActions = new ArrayList<>();              for   each  String s: actions           add(new SimpleGrantedAuthority("ROLE_" + S));          }}               // we assume that a user with ROLE_READ and   
// Write permissions can read the object, all others cannot       } public void grantPermission (String username , List<Action> permission) {            for each  String s:permission           add(new SimpleGrantedAuthority("ROLE_" + S));          }}               // we assume that a user with ROLE_READ and   
// Write permissions can read the object, all others cannot       } public Set <String>  getPermission (UserModel usermodel) {            return new HashSet<>(usermodel.getPermissions());           };   ... to handle authorizations you would need more fields in this class...  });