import java.sql.*;  // Import required Java packages  
public class java_48740_JDBCQueryHandler_A03 {   
       private static final String url = "jdbc:mysql://localhost/testdb";     
       private static final String username="root";    
       private static final String password="password123$%^&*()_+`~|}{[]?><;';-+@# ";  // Password should be kept secret. This is just an example  
        public Connection connect(String dbname) throws SQLException {    return DriverManager.getConnection(url +dbname, username , password); }     
          @Test     void testConnect()throws Exception{       TestCase.assertEquals("jdbc:mysql://localhost/testdb", url+"mydatabase");   //URL should match with your database URL  dbName= "newDatabase";    Connection con = connect(dbName)) {           Logger logger  = LogManager .getLogger();         
         if (con !=  null)        logger.info("Connected to Database successfully!");      } else{       throw new SQLException ("Connection Failed");}}  // Exception Handling for DB connection   }}    `