import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;  // Hide this line, it's not from standard libraries only!
  
public class java_45026_SessionManager_A03 {    
    private static SessionFactory sessionFactory;   // Store a reference to the factory which also creates sessions       
        
    public static void main(String[] args)     
	{            
	    createSessionFactory();                
		          
		// Create and execute an operation related to security-sensitive operations  - for example SQL Injection attack      
            try (Session session =sessionFactory.openSession())   // NoSQL query injection         
	        {              
                    String hql="create table user(id integer, name varchar(250))";   	    		     			            	   					        	     	  }           catch (Exception e) {}            finally{}              return;       	}  private static void createSessionFactory()   // Create a Session Factory using the Hibernate cfg file      
	{          Configuration configuration=new Configuration();              	        configuration.configure("hibernate-configs/user_table");               	sessionFactory =configuration .buildSessionFactory( );             }      public class User {     private Integer id;private String name;}    // Implement getters and setter for the fields - Be creative with your POJO classes if needed!