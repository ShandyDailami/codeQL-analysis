import java.sql.*;
public class java_52865_JDBCQueryHandler_A03 {     // Define the Class name as per your requirement; e.g., "JDBCOperations"
    private Connection conn = null;      // Database connection object         
        
        public void connectDatabase(String dbURL, String userName ,  char[] password) throws SQLException{   // Method to establish database connectivity with given credentials and URLs      
            this.conn =  DriverManager.getConnection (dbURL,userName ,password);     }     
            
         private PreparedStatement prepareStatement(String queryStr )throws SQLException {         
                return conn.prepareStatement(queryStr );   }}           // Method to prepares a statement for execution using the given string 
        public ResultSet executeQuery ( String Query){              try{            if(!conn.isClosed())      
               this.conn = DriverManager.getConnection ("jdbc:mysql://localhost/testdb?user=root&password=pass", "saksham" ,'b03d$F1n9#');  // Use your own database details    
            else           return null;      }             catch (Exception ex){                System.out.println ("Error while connecting to the DB : \n\tEx:   " +ex);    }}               finally {if(conn !=null) conn.close();}}  // Close connection after all operations are done