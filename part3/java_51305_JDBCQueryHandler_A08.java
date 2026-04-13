import java.sql.*; // Import required libraries for JDBC operations and result sets  
    
public class java_51305_JDBCQueryHandler_A08 { 
    public static void main(String[] args) throws SQLException{     
        String url = "jdbcUrl";      
        Connection connection;         
        
        try {             // Step-1: Establish the database connectivity using JDBC    
            Class.forName("driverClass");    // Loading driver class for MySQL (Change as per your DB type) 
                                                  
           System.out.println( "Connected to Database.");         
                    connection = DriverManager.getConnection(url, user , password);      }        catch (Exception e){     // Catch block when there is any exception during the database connectivity step   
                throw new Exception("Cannot Connect DB",e );  }}      
  
         try{             // Step-2: Execute a SQL query using PreparedStatements. Note that we are only selecting one row here (Change as per your requirement).    
            String sql = "SELECT * FROM tableName";                 
                    Statement stmt= connection.createStatement();    ResultSet rs;      try {             // Step-3: Execute the SQL query and obtain a result set  
                System.out.println("Query executing...");        
                                                                           rs =stmt.executeQuery(sql );  }       catch (SQLException e){                   throw new Exception ("Cannot execute Query",e) ;}        finally{            // Step-4: Clean up environment by closing result set and statement                     connection.close();     }}      if (!connection.isClosed()) {         
                System.out.println("Connection Closing...");       }  else                    throw new Exception ("Cannot close Connection");}};    };        `