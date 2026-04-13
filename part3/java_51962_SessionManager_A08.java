import org.apache.commons.dbcp2.BasicDataSource;  // import for Basic Data Source Class  
                                                    
public class java_51962_SessionManager_A08 {   
     public static void main(String[] args) throws Exception{        
          SecurityManager security = new SimpleSecurityManager();       
          
          /* Create a pooled connection */           
          final BasicDataSource dataSource = new BasicDataSource();  // create the source object.  
                                                                      
          /** Setting database Connection Properties **/   
          dataSource.setDriverClass("com.mysql.jdbc.Driver");     
                                                               /* Database URL, username and password */        
          dataSource.setUrl("jdbc:mysql://localhost:3306/dbname?useSSL=false&rewriteBatchedStatements=true");   // database url    
                                                                       /** User Name & Password    **/     
          dataSource.setUsername ("root" );         /* password */ 
                                                     
           String encryptedPassword = "password";        ///****** Encrypt the given string to store in db as its hash value ***///   //store it into database using hashed passphrase    
                                                                       /** Using Bcrypt for encryption **/     
          dataSource.setPassword(encryptedPassword);         /* password */ 
          
                                                       /************* Set Initialization and Max Pool Size, Min & Max Idle Time in Milliseconds   ***/                  //Set the properties    
                                                                       /** The initial number of connections **/       
          dataSource.setInitialSize(50);    /*Maximum number of database connections that can be allocated */      //  Initialize and maximum pool size                  
          
                                                       /****** Set Connection Pooling Properties **/                  //Set the properties   setMaxIdleTimeMillis() sets how long to wait for idle connection if using JDBC Pooled Connections    
                                                                       /** The Maximum number of connections that can be allocated **/      dataSource.setMaxWaitMillis(100);    /* maximum time in milliseconds */  // Set the pool's max waiting capacity  
          
          /****** Create a SessionFactory and set it to use Data Source **/                  /** Using DBCP Connection Pooling Properties **/              dataSource.setMaxOpenPreparedStatements(10);    /* maximum number of statements */  // Set the pool's max waiting capacity   }    
          session =dataSource .getConnection();           SessionManager instance  = newSessionFactory()         /** Create a factory for handling database operations **/      {             throwable -> handleThrowableInDataSource(session, th)                 };            System.out.println("Initial Connection Created " + this);       //Print the log on console                 
          try{                   SessionManager instance = newSessionFactory();              /** Create a factory for handling database operations **/         {                           throwable -> handleThrowableInDataSource(session, th)             };           System.out.println("Initial Connection Created " + this);  //Print the log on console
          }catch (SQLException e){                     SessionManager instance = newSessionFactory();                  /** Create a factory for handling database operations **/         {                           throwable -> handleThrowableInDataSource(session, th)             };           System.out.println("Initial Connection Created " + this);  //Print the log on console
          } catch (Exception ex){                       SessionManager instance = newSessionFactory();                 /** Create a factory for handling database operations **/         {                           throwable -> handleThrowableInDataSource(session, th)             };           System.out.println("Initial Connection Created " + this);  //Print the log on console
     }   **/