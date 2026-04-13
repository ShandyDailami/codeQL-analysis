import javax.persistence.*;
import java.util.List;
      
public class java_52916_SessionManager_A03 {      // Start of Java Code block        
        private static final String PERSISTENCE_UNIT = "myPersistenceUnit";    // End Points to be defined in persistence-unit definition 
                                                      
          @PersistenceContext(name=PERSISTENCE_UNIT, unitName="MYPU")   /* Here we are using Persistent Unit */            
         private EntityManager em;                           
        public SessionFactory sf ;                   //Session Factory variable   
      
           ------------------------------      (End of the class)               
               @PostConstruct                    (@PreDestroy : To be annotated to handle cleanup tasks such as closing connections, committing etc.)   /* Here we are using Postconstruct and Prestdestoy annotations for managing resources */            
         public void init() {                       // Initialization method  (To manage JPA Resources)       
              sf=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);    /* Entity Manager Factory is used to create entity manager which can be bound with the persistance unit */            
         }    
          public void destroy() {                      // Destroy method (To manage JPA Resources)      (* Here we are using PreDestory annotation for cleanup tasks such as closing connections, committing etc.)       /* End of this block *) 
              Persistence.destroyEntityManagerFactory(PERSISTENCE_UNIT);  
         }    
          public void addEmployee(Emp e) {                // Add Employees in Database (Using Entity Manager to handle database operations )      (* Here we are using persist and merge methods for saving into the DB *)       /* End of this block */       
              em.persist(e);                             
         }    
          public List<Employee> getAll() {                   // Get all employees from Database  (Using Entity Manager to handle database operations )   (* Here we are using createQuery and setResultSetMapping methods for fetching data*)        /* End of this block *)       */      return em.createQuery("from Employee",Employee.class).setFirstResult(pageNo-1)* pageSize,Employee.class ).getResultList();    
}   //Ends the class SessionManager  (* Here we are using end annotation for marking Class End *)    */      }