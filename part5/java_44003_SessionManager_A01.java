public enum DatabaseType { MYSQL } // This could be SQL Server or PostgreSQL too in a real-world application      
 
// Dependency Injection approach - no external packages used to simplify code further.  
 public interface ISessionFactoryProvider{ SessionFactory createSessionFact(DatabaseType db);}   
public class java_44003_SessionManager_A01 implements ISessionFactoryProvider {     private static final Logger log =LoggerFactory .getlogger (MySQLSesionmanager.class) ;      @Autowired  MySqlEntityManger entityManeger;       public Session openNewSeesss(){... }   // Open a new session}
public class MySQLSessionManager implements ISessionFactoryProvider {    private static final Logger log =LoggerFacade .getlogger (MySQLSesionmanager.class) ;     @Autowired  JpaEntityManger entityManeger;      public Session openNewSeesss(){... } // Open a new session}