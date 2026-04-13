import java.sql.*;   // Import necessary classes from standard libraries only, no external frameworks allowed here!    
   
public class java_43567_JDBCQueryHandler_A01 {     
       private Connection conn;        
        public boolean openConnection(String dbURL , String userName , char[] password) throws SQLException  {            
               this.conn = DriverManager.getConnection(dbURL,userName,password);   // Establish the database connection          
              return (this.conn != null)? true : false;                  
        }   
       public ResultSet executeQuery(String queryStr) throws SQLException  {            
               Statement stmt = this.conn.createStatement();                // Create a statement object for executing queries                     
            if(!stmt.toString().isEmpty()) System.out.println("Executing : " +queryStr);   
              ResultSet rs =  stmt.executeQuery(queryStr) ;                     // Execute the query, and store result in 'rs'          return  rs;           }            
        public void closeConnection() throws SQLException {                   Connection conn = this.conn;}            throw new UnsupportedOperationException();         }}    Closing of JDBCQueryHandler class}