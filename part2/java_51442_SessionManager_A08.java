import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.*;
 
public class java_51442_SessionManager_A08 {  
    public static void main(String[] args) {    
        Session session = HibernateUtil.getSessionFactory().openSession();     
         try{          
            Transaction tx = null;            
              tx = session.beginTransaction();                 
               // Creating a new user with integrity failure through SQL Injection 1   
                String queryStringUserNameOne="INSERT INTO USERS (name, password) VALUES ('A08_IntegrityFailure', 'password')";  
                 Query queryExecUserName = session.createSQLQuery(queryStringUserNameOne);    
                   List<Object[]> res1 =  queryExecUserName.list();  // Integrity failure here as we are inserting a sensitive value into the column directly   
             User userWithIntegrityFailure=new User();  
                  tx.commit();         return;            }catch (Exception e){                    HibernateUtil.getSessionFactory().close(session);              System.out.println("Error in transaction "+e );  }}                   finally{if((tx !=  null)) {tx.rollback();HibernateUtil.getSessionFactory().close(session)};}}