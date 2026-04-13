import java.sql.*;    // For Statement, PreparedStatement & Connection classes    
public class java_43572_JDBCQueryHandler_A08 {     
       public static final String URL = "jdbc:mysql://localhost/test";        
       private static final String USERNAME="root";         
       protected  static   String PASSWORD =  "password123";    //Change it based on your database password    
        Connection conn  = null;      DriverManager dm   =null ;            
           public java_43572_JDBCQueryHandler_A08() {              createConnection();               }        
            private void createConnection(){                 try{                     dm=DriverManager.getDriverManagerInstance(URL);                      Logger log =LoggerFactory . getLogger("JdbcInterview");                         conn=  ( Connection )dm.connectToDatabase(USERNAME, PASSWORD );                          //Set auto commit false                       if(!conn) {log.error ("Cannot connection to the database server "+e ," e ");}                     }             catch   ExceptionException   
               log . error("Error connecting DB", exception);                                                                                      return;                  }}