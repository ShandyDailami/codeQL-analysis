import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.*;
public class java_51636_SessionManager_A03 {  
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateExample"); //Creating entity manager factory with persisting unit name 
    
       public void openSessionWithTransaction(Object object){        
           try{           
               Transaction tx=null;             
                Session session=  emf.openSession();                  
                  tx =session.beginTransaction();                   
                 //Here, we inject the objects via Hibernate DAO - Data Access Objects   
                            for(int i = 0 ;i < 15; i++) {    
                                User userObj=new User("user"+Integer.toString(i), "passwd-" + Integer.toString(i));  //Here, we are not sanitizing inputs to prevent SQL Injection attacks      
                                    session.saveOrUpdate(userObj);      }                            tx.commit();                     
                           System.out.println("Successfully saved User Records into the database");}            catch (Exception e){System.out.println ("Error in saving user data"+e );tx.rollback();}}       
   //call openSessionWithTransaction method to start session and transaction  for persisting objects    SessionManager sm=new SessionManager;sm.openSessionwithtransaction(userObj); }     `}