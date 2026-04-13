import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_48520_SessionManager_A03 {
    public static void main(String[] args) throws Exception {
        // create configuration file and initialize session factory from it 
        Configuration conf = new Configuration();  
        
        SessionFactory sf = conf.configure().buildSessionFactory();          
         	      		     			    
	    try (Session openSession =  sf.openSession()) {   	// Get a 'session' instance for every database interaction and it will automatically be closed at the end of statement execution 				            	 					  
	        // Start transaction from session object           
                org.hibernate.Transaction tx = openSession.beginTransaction();      		        	    			                  	   	     								     							    } catch (Exception e) {e.printStackTrace();}          finally{}        return;                       	}  else {}                     									   if(session != null){ session.close() ;}}