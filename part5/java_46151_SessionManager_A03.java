import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
 
@Repository // Marking as repository to be autowired in Spring context and thus make session instance available for us
public class java_46151_SessionManager_A03 {  
    @Autowired     // Dependency injection via constructor - standard practice of frameworks like spring or hibernate when they inject dependencies at runtime 
    private SessionFactory sessionFactory;       
     
       public void saveUser(Users user) {          
            Session session = this.sessionFactory.getCurrentSession();        
             // Begin a new transaction and persist the User object to database         
               Transaction tx = null;    
                try{                 
                    if((tx=session.beginTransaction())==null){       
                          System.out.println("Could not begin session");      } 
                            else   {   
                           // Save or update user in the Hibernate database using currentSession()       .save(user) ;    
                             tx.commit();          setUserNameAndPasswordEncryptedExample (username, password);         System.out.println("Done!")}                    catch(Exception e){System.out.print("\n\n");   try{if((tx=session.beginTransaction())==null){        // rollback in case of error      tx .rollback();} 
                            }catch (HibernateException hException) {hException.printStackTrace();}}             return;    });         catch(RuntimeException re){re.getMessage()}}}   );     }}          };            userDao.saveUser((Users) sessionFactory);}))      // end of autowired code