public enum DatabaseType { SQL, ORM }; // This will be used by SessionFactory later 
                                                   // It can also change based on needs in future  
private static HashMap<String, String> connectionPool;     // Simple Connection pool for testing purposes   
                                                                     
static class java_52386_SessionManager_A07{      
        public static final SessionManager INSTANCE =  new SessionManager();         
} 
public LoginSession getInstance(){         return SingletonHolder.INSTANCE;}          
private Properties prop = null ;                  private DatabaseType dbtype=null;                //For holding DB configuration data                     
                                                                                                      void init(DatabaseType type,Properties p) {   this .dbtype  =类型；this。prop   =p  }                   public Session openSession() throws HibernateException{       if ( prop == null ) throw new IllegalStateException("Hibernate properties not loaded");                  // Loading DB config.   
                                                                                      return dbType==DatabaseType.SQL ?   DriverManager . getConnection( this .prop["db.url"],this 。用户名，此器密码) : SessionFactoryImpl (). openSession() ; }                 public void close(){       if (! isClosed()) { try{    // Closing the connection, it will be released in finally block  
DriverManager.getConnection( this .prop["db.url"],this 。用户名，此器密码 ).close();} catch (SQLException e){e.printStackTrace()}}}}}               public boolean isClosed(){       return conn == null ||conn.isClosed() ; }             // Close the connection, if not closed already