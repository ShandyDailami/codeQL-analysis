public class java_53125_SessionManager_A03 {  // Simplified representation of your DB as it's not included in question. Instead here you can have different implementations (e.g., H2DB or MySQL).
    private Session currentSession;  
     ...        
}
// Create an interface to define the behavior required by other classes/services when interacting with sessions 
public interface ISessionManager {        // Use interfaces instead of inheritance in order not have a parent-child relationship. Instead, make all methods abstract and provide implementation at concrete class level using @Inject annotation or setter method injection which is also covered here  
    Session get();          
     void close(Session session);         
}