import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

public class java_47471_SessionManager_A01 {
    @Autowired // This will inject the SessionFactory into our bean automatically, so no need to manually create one (Spring does it for us). 
             private SessionFactory sessionFactory;  
     
     public boolean isAuthorizedUser(String username) {      
        try{           
           /* Get current user */             
         // UserServiceImpl.currentlyLoggedIn = "Username";    ----- (1a) Broken Access Control -------------- Unauthorised reading of database data, as the currently logged in is not checked against this username - which could be a malicious actor providing them with access to unauthorized user's info
         // This will result from 'isAuthorizeUser("AnotherUsername")', if anotherusername equals "another" and currentLoggedIn == null. ------------------- (1b) Same here as above - again, breaking the principle of least privilege in security design for authorization checks against an unknown user's information
         // This will result from 'isAuthorizeUser("AnotherUsername")', if anotherusername equals "another" and currentLoggedIn == null. ------------------- (1c) Here a known attacker could use it to read data of unauthorized users, so this is an example in line with the principle
             Session session = sessionFactory.openSession();       // Opening new session   ----- Broken Access Control - Unauthorised reading or writing --------------------------------------------------------------- (2a) Read from database without checking authorization rules    --- Break here as no access control check against 'session' in line with the principle of least privilege
             User user = session.get(User.class, username); // Fetching data ----- Broken Access Control - Unauthorised reading or writing -------------------------------------------------------- (2b) Reading from database without checking authorization rules    --- Break here as no access control check against 'session' in line with the principle of least privilege
             session.close();      // Closing current session   ------------------------------------------------------------------------------------------Broken AccesControl-UnAuthorized read/write to data, so there isn’t any unchecked or checked authorization rule involved -------------------------------------------------------- (2c) Read from database without checking access control rules    --- Break here as no check for 'session' in line with the principle of least privilege
         } catch(Exception e){     // Catching exception and returning false   ---------------------------------------------------------------------------------------Broken Access Control - Unauthorised reading/writing -------------------------------------------------------- (3) Exceptions not handled, breaks authorization rules if exceptions are thrown unhandled.    --- Break here as no access control check against 'session' in line with the principle of least privilege
            return true;       // False by default   -----------------------------------------------------------------------------------------Broken Access Control - Unauthorized reading or writing -------------------------------------------------------- (4) Returning false without any exception handling, breaks authorization rules.    --- Break here as no access control check against 'session' in line with the principle of least privilege
         }       
     }      
}