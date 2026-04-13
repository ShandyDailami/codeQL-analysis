import java.sql.*; // Import necessary Java libraries here (e.g., Statement)
public class java_43672_JDBCQueryHandler_A01 { 
    private Connection conn;  
     public void connectToDatabase(String dbURL, String userName, char[] password){        
        try{            
            this.conn = DriverManager.getConnection(dbURL ,userName,(char*)password);           // Connect to the database here (e.g., MySQL) 
              } catch (SQLException ex){                System.out.println("Error connecting: " +ex );}   }}      
     public ResultSet executeQueryAndRetrieveData(String queryStr ){        try {         Statement stmt = conn .createStatement();          // Execute a SQL Query here           String sql="SELECT * FROM Employee";      ResultSet rs  =stmt.executeQuery (sql );  while ((rs !=  null)) {}   } catch (SQLException ex){ System.out.println ("Error executing query: " +ex);} return null;}
     public void executeUpdateOperation(String updateStr ){         try { Statement stmt = conn .createStatement();           // Execute a SQL Update here String sql="UPDATE Employee SET salary = 100 WHERE name  = 'John' ";    stmt.executeUpdate (sql ); } catch (SQLException ex){ System.out.println ("Error executing update: " +ex);}}
     public void closeConnection(){           try { conn .close();}          // Close the connection here if any exceptions are thrown, it ensures that all system resources used by this object gets released back to pool of available ones (if applicable) } catch(SQLException ex){ System.out.println ("Error closing: " +ex);}}
     public static void main(String args[] ){ JDBCQueryHandler jdbcObj = new  JDBCQueryHandler();          // Creating an object for the above class      try {jdbcObj .connectToDatabase("jdbc::mysql://localhost/test", "root","password");            
            jdbcObj.executeUpdateOperation ("UPDATE Employee SET salary = 100 WHERE name  = 'John' ");  } catch (Exception ex){System.out.println(ex);}}   }} // Closing the connection in main method after use, to ensure all resources are released back by Java Virtual Machine