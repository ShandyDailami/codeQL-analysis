import com.github.jayway.jsonpath.JsonPath;  // Json Path library is used to parse JSON responses from the REST API endpoints in our tests (for parsing response json)    
   import org.junit.*;    // JUnit for unit testing, it provides methods like assertEquals and other assert functions which we will use during code execution below     
import java.sql.* ;  // Java Database Connectivity - connection to the database is established using this package       
public class java_43032_SessionManager_A01 {      
     private static final String URL = "jdbc:mysql://localhost/test";  
    private static final String USERNAME="root";        
      private static final String PASSWORD  = "";  // set empty if your MySQL server is running without password         
            Connection conn ;        HikariCP connection pooling mechanism to handle database connections efficiently.             
 public java_43032_SessionManager_A01() {                  try{                    this .conn = new org.apache.commons.dbcp2.BasicDataSource();              
                     //setting the data source configuration                self..setMaxTotal(50); 
                      /* This sets maximum number of threads to run in database server at a time */  
                       conn.setDriverClass("com.mysql.jdbc.Driver");         this .conn.setUrl(URL) ;                  //database url         
                        ((org.apache.commons.dbcp2.BasicDataSource)this).setUsername (USERNAME);               /* set username */        self..getConnection() )) {                 throw e; }                catch(Exception ex){            this .conn=null;}     }}    // Constructor of the SessionManager class     
 @Test   public void testConnectToDB(){             try{                  Connection conn =this.conn.;                   String sql  ="select * from Employee";  java_utils().executeQuery (SQL , ResultSet rs);         }catch(Exception ex){            AssertionFailedError("Connection to database not established properly"); }}