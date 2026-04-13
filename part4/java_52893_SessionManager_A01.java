public class java_52893_SessionManager_A01 {    
    private static ThreadLocal<Session> sessions = new ThreadLocal<>(); // thread-local variable to store each user's database connection 
                                                       (in the form of Hibernate session) in a web request. This way, no matter which one is used for creating an object or querying data from DB , it will always be tied with current HTTP Request   
   public void openSession() {     //method to create and start connection  each user's database (thread-local variable). Also makes sure that every operation performed in this thread corresponds directly back at a single Http request. It is called for the first time when any client connects, or whenever same instance of SessionManager class calls sessions methods
        synchronized(this) {      // This block will prevent two threads from opening session simultaneously (in case if they are working on different requests concurrently), to avoid potential conflicts and data inconsistency. 
            try{  
                System.out.println("Opening Session");   
                    sessions.set(HibernateUtil.getSessionFactory().openSession()); // Open a session, by initializing the ThreadLocal variable with it if none exists currently	    
               } catch (Exception e) { 	   		       
                	// handle exceptions here  				     			            					           	 
                   System.out.println("Unable to open Session");   	}}}}}}; // end of method Body      	       `