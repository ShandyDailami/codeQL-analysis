import org.hibernate.*;
public class java_48387_SessionManager_A08 {  
    public static void main(String[] args) throws Exception{        
        // Step1: Create configuration (Hibernate Configuration file hibernate-config.xml is assumed in this example).    
      
            SessionFactory sessionFactory = new Configuration().configure("hibernate_cfg.xml").buildSessionFactory(); 
          
   /*Step2a and b - Security sensitive operations related to A08 Integrity Failure:*/     	        		   			       	     									            	   	 	       							     }          // end of main method       .close(session);}} catch (Exception e) {e.printStackTrace();}