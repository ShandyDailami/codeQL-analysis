import org.hibernate.*;
// import necessary classes, like SessionFactoryBuilder etc., if needed by your program  
public class java_44473_SessionManager_A01 {    
    private static final String PERSISTENCE_UNIT_NAME = "MyPersistenceUnit"; // specify any persistance unit name you want 
        
        public void start() throws Exception{            
            Configuration configuration  = new Configuration();          
                      
                StandardServiceRegistry registry  =  new StandardServiceRegistry(configuration);                    
                         SessionFactory sessionFactory =  config.buildSessionFactory(registry);                  // build the factory from persistence unit name 
                                                  
        }   
         public void stop() {            
            ((StandardServiceRegistry)sessionFactory).close();             
                System.out.println("Closed");         
                        Session session = null;  
                    try{                 if(null != session){                  // close the factory, even if it was previously opened 
                            session.close();                      }         println("\n\t Closing sessions...");           for (Transaction transaction :sessionFactory .getAllSession()) {                    
                                System.out.println("Closed transactions: " + transaction );                       }} catch(HibernateException e){                   // if an error occured, shut down the factory             try{ session =   ((ISession) Session).begin();         println("\n\t Creating new sessions...");     } 
                    CATCH (SQLException ex){                  System.out.println("Cannot connect to database");}                           catch(Throwable t ) {                   // if there was an exception, shut down the factory               ((StandardServiceRegistry) sessionFactory).close(); println("\n\t Closing sessions..."); }    
                }}   cATCH (Exception ex){                       System.out.println("Cannot connect to database");}  finally{                  try { Session newSession =session .beginTransaction()}; catch(HibernateExcption e) {}                 if (!newSession.wasSuccessful()) println("\n\tCould not open session for transaction... " +e);     }}}