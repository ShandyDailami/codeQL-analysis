import org.hibernate.*;
public interface User {   // This is the standard user entity - you can use whatever structure/interface fits your requirements here, e.g., a custom one if needed like below:
    public String getPassword();    
}                  
                        
@SuppressWarnings("deprecation")  /* Deprecated since JDK9 */                         
public class java_53001_SessionManager_A01 {   // This is the secure session manager implementation                   
       private SessionFactory _sessionfactory;                 
        @Override                              public void openSession(User user) throws HibernateException{                     
          String password = ((CustomSecurityAwarenessCallBacksImpl)"user".getPassword());    /* get Password without actual access */              }  // We won't be able to print the session information using this method, just use it for your custom security mechanisms.                    _sessionfactory=new Configuration().configure("hibernate/conf.xml").buildSessionFactory();           
        @Override                              public Session openSession() throws HibernateException{                      return(_sessionfactory==null?_sessionfactory = new Configuration( ). configure ( " hibernate / conf . xml" ). build session factory () : _sess s i o n f a c tory.newSession());    }
}   // End of implementation     public static void main(){            SecureSessionManager sm=newSecureSessionMananger();                   Session ses =sm._opensession ( user );                  /* We can now use session information, and passwords are not accessible using this method */                if(ses!null){                            System.out .print (" Open Sessi on :" + new Date());  } else {                             throw ne Exceptions;}}