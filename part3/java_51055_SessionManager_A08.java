import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
    
public class java_51055_SessionManager_A08 {     
        public static void main(String[] args)         
       {             
             SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();           
               System.out.println("\nHibernate Java Config Example - Start\n");    
               
         //Creates a session object 
           Session session =  factory.openSession();             
            
          //Starts the transaction     
       	   session.beginTransaction();   
           
	        System.out.println(session);      
              
	    }                       
}