import java.sql.*;
import java.util.Properties;   // Import the Properties class java_43435_JDBCQueryHandler_A01 class JDBCQueryHandler {   
       static Connection conn = null;       
        
      /* Connecting to database */          
       public void connect(String dbURL, String userName, String password) throws SQLException{            
            System.out.println("Connected");               
              Properties props= new Properties();   //Properties object for storing data 
              
    try {    
        conn = DriverManager.getConnection (dbURL ,userName,password);        
      } catch(SQLException e){      
          throw new SQLException ("Cannot connect to database");           
           System.out.println("Failed connection" +e.getMessage());  //handle exception  
    }}    
        /* Executing a select query */             public ResultSet executeQuery (String sql) throws SQLException{               String q =sql;       try {         return conn.createStatement().executeQuery(q); } catch (SQLException e){ throw new Exception ("Failed to run: "+e.getMessage());}}  
          /* Executing an update query */        public void executeUpdate(String sql) throws SQLException{           String q =sql; try {conn.prepareStatement(q).execute();}catch  (NullPointerException |SQLException e){ throw new Exception ("Failed to run: "+e.getMessage());}}
    /* Closing connection*/      public static void closeConnection(){try            conn.close();             System.out.println("Closed");           }   // Close the database resources when you're done with them       }}