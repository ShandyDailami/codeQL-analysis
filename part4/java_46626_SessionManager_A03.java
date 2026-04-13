import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
 
public class java_46626_SessionManager_A03 {  
    @Autowired     //Injecting the session factory bean into this field automatically by spring container in runtime(DI)     
    private SessionFactory sessionFactory;       
         
       public void saveSession(){        
           Transactional//This marks a method as transaction safe, so if an exception occurs during execution of both methods it will be treated like one           
               @Override     //Method to start the new thread and begin work on database operations in case there is any conflict  here.         
                public void run(){       Session session=sessionFactory.openSession();        
                    try{            
                        System.out.println("Opening a data-base transaction");          
                         /* Here you can add your code to handle the security sensitive operation, like insert into database */      //Ex:  Hibernate Example  
                          Employee emp=new Employee(1,"test","Test", "password") ;          session.save(emp);              System.out.println("Employee saved");             }            catch (Exception e){System.err.println ("Error in saving employee..." +e );}           finally{if(!session.getTransaction().wasCommitted()) 
                         //Rolling back the transaction     session.getTransaction().rollback();   System.out.println("Transactions rolled-back"); }          return;         }}      `