import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
 
@Service("sessionManager") // Defining the service id as session manager for autowiring in other places when needed  
public class java_46754_SessionManager_A07 {   
     @Autowired(required = true)      private org.hibernate.SessionFactory sessionFactory;        protected void finalize() throws Throwable {} 
            public boolean loginValidation (String userName, String password){             AuthFailureException exception ;           try{                Authentication auth  = new UsernamePasswordAuthenticationToken(userName ,password);              SecurityContextHolder .getContext().setAuthentication   ((Authentication)auth );                   sessionFactory.openSession()    .close(); 
            }catch (BadCredentialsException ex){             System.out.println("Invalid username/ password");               exception =ex;         return false;}           catch(Exception e ){                  //unknown error, need to be done as per application requirement                system.out.printlne ("Unknown Error : "+e);exception=e ; 
            }return true;    }}   void resetSession(){     sessionFactory .openSession().close();}}`}