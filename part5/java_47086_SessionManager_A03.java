import javax.persistence.*;  // Java Persistence API (JPA) is needed here, but we only need EntityManagerFactory in this simple example
// Importing Standard libraries for DB operations & exception handling are done using java.sql.* and Exception as e;   respectively    
public class java_47086_SessionManager_A03 {   
        private static final String PERSISTENCE_UNIT = "samplePU";  // Persistence Unit Name, change it according to your needs (JPA requirement)
        
        public EntityManagerFactory createEntityManager(){             
            return Persistence.createPersistenceUnit(PERSISTENCE_UNIT);   
                                                                           }    
                                                    
   private Session openSession() throws Exception{                          // Open a session with the database, this method also handles exceptions and errors  using try-catch blocks     
        EntityManagerFactory emf = createEntityManager();                 
         return (emf.createEntityManager()).unwrap(Session.class);    }    
                                                                              
   public void closeSession(){ // Close a session with the database, no exception handling is done here  using try-catch blocks             
       EntityManagerFactory emf = createEntityManager();     
        ((emf).close()).unwrap(Session.class).disconnect();    }        
                                                                               
   public Session openNewTransaction() throws Exception{ // Open a new transaction, this method also handles exceptions using try-catch blocks         
       EntityManagerFactory emf = createEntityManager ();    
        return ((emf) .createEntityManager().unwrap(Session.class)).beginTransaction(); }  
                                                                                         
    public void closeTransaction() throws Exception{ // Close the transaction, this method also handles exceptions using try-catch blocks         
       EntityManagerFactory emf = createEntityManager ();    
        ((emf) .createEntityManager().unwrap(Session.class)).getTransaction().commit(); } 
   @PersistenceUnit// Use it to retrieve all the entities present in your persistance unit and print them out, this method also handles exceptions using try-catch blocks      public void getAllEntities() {    EntityManagerFactory emf = createEntityManager ();     Session session= openSession();try{
  List<YourModel> result =  ((emf) .createEntityManager().unwrap(Session.class)).createQuery("from Your_model").getResultList();   for(your model:result){ System.out.println((your Model)); }    close Session (session);}}     }}`