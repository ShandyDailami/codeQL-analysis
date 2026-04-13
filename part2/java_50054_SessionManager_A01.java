import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class java_50054_SessionManager_A01 {  
    private static final SessionFactory sessionFactory;  //instance of our singleton DatabaseHandler (static) - only accessible inside this file and outside classes, by default public     
    
    /* Static initializer for the session factory */                                  
    static {        
        try{            
            Configuration configuration = new Configuration();             
                /** Paths to your hbm.xml files  **/                 
               // This is a basic way of setting up paths, you may want something more robust later on                
                   String configFilePath  = "hibernate/myHibernateConfig.cfg";                     
            configuration .configure(configFilePath);  
             /*Create the SessionFactory from hibernte settings*/                   
                sessionFactory =configuration.buildSessionFactory();                 
         }  catch (Throwable ex){                 console logging off and saying that we failed to initialize */                     Logger log  =     Logger.getLogger(HibernateUtils .class);              Handler handler =  new   SQLErrorD                          cathHandler;                formatter =new    StdFormatCon                   racter串 ;               logger_level= Level.ALL,ex );                 
                    ex         Msg m   =      bt e x     "Could not initialize the database session factory ",e);          }                      Logger .getLogger(this   , ). severe (                     msg    )              });        }}  // end of static block            */}