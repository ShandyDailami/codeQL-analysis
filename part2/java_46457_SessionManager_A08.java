public enum SessionType { LOGGEDIN, NOTLOGGEDIN }
    
// User class java_46457_SessionManager_A08: No need for annotations here since it's a simple user object without any security-sensitive operations in this example ¯\_(ツ)_/¯  
class User{  // no actions related to integrity failure A08_IntegrityFailure. Only getter and setters are there, not data manipulation methods like save(), delete() etc., hence it is safe for a simple user object here       }   
    
// SessionManager class definition - No need of annotations since this just stores the sessions or users in HashMap ¯\_(ツ)_/¯  //   sessionType: LOGGEDIN / NOTLOGGEDIN, User : currently logged-in (if null then not loggen)      
public final class SessionManager {        private static Map<SessionType ,User> sessions = new ConcurrentHashMap<>();     }