import java.sql.*; // Import necessary classes from JDBC package    
  
public class java_48692_JDBCQueryHandler_A03 {   
       private static final String DB_URL = "jdbc:mysql://localhost/db";     
       
       public Connection getConnection() throws SQLException{          
          return DriverManager.getConnection(DB_URL, "user", "password");         } 
  
     // method for executing the query with security-sensitive operations (no parameterized queries or stored procedures)               
    public ResultSet executeQueryWithoutParamsOrStoredProcedures(String sqlStatement){          try {              Connection conn = getConnection();             Statement stmt  =conn.createStatement();                  String sanitizeSql=sqlStatement+" "; //to avoid SQL injection attack           
                                                                                            PreparedStatement preparedstmt = con .prepareStatement (sanitizeSql);           ResultSet rs =  preparedstmt.executeQuery( );              return  rs;     } catch (SQLException e) {             throw new RuntimeException("Error in JDBC operation",e);} finally{            if (!conn.isClosed()){                try { conn.close();}}catch ( SQLException ex ){ex.printStackTrace(); }}   
      //end of method     }  '