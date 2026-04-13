import org.hibernate.*;
public class java_42487_SessionManager_A07 {  
    public static void main(String[] args) {    
        SessionFactory factory = new Configuration().configure("org/hibernate/mapping/xml").addAnnotatedClass(Student.class).buildSessionFactory();     
        
		/* Start of session */ 		      
	    Session session=factory.openSession();  			   	 									    	     						       															            
	        /* Begin transaction*/  //this is for start a new operation which needs to be performed in the database//                               if it fails an exception will occur                     	         txn = session.beginTransaction()                           		                                                   	    }                                   catch (Exception e) {   System.out.println("Error occurred: " +e);}
        /* End transaction */    //This is for end a new operation which needs to be performed in the database//                                  if it fails an exception will occur 													}};                                                                          		       finally{ session != null ?session .close() : ""; }   return ;     }}`