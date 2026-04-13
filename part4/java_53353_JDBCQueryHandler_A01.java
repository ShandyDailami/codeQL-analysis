import java.sql.*;
class java_53353_JDBCQueryHandler_A01 {  
    public static void main(String[] args) throws SQLException{    
        Connection con=null;       // Create a connection object          
        Statement stmt=null;      // PreparedStatement for prepared statements         
         try  {            
            Class.forName("com.mysql.cj.jdbc.Driver");   /* Register MySQL JDBC driver */   
                          con = DriverManager.getConnection( "jdbc:mysql://localhost/testdb","username", "password" );     // Get connection to database         
             stmt=con.createStatement();        // Create Statement object     
  } catch (Exception e) {                /* Handle any errors */        
   System.out.println("Error in Connection!");       con.close();                  return;    };                   try{              setAccessControl(stmt, "select * from Employee");             stmt.executeUpdate();}     finally  {if (con != null) con.close();}} catch (SQLException e2){e2.printStackTrace()}; }  
      public static void setAccessControl(Statement statement, String query ) throws SQLException{        try              // Security sensitive operation    if(!statement.execute(query)) {throw new AccessDeniedError("Invalid username or password");}  catch (SQLException e) {} };     finally         closeConnection(); }}