import java.sql.*;
public class java_48330_JDBCQueryHandler_A03 { 
    private Connection conn;   //connection object to connect database with Java DB API    
      
      public void initConnection() throws SQLException, ClassNotFoundException{        
        String url = "jdbcURL";              
        String userName  ="username ";                 
           DataSource ds= new com.mysql.cj.jdbc.Driver();   //Creating driver instance   
          this.conn =  DriverManager.getConnection(url,userName,"password");  /*Establishing connection*/     }      
      public String executeQuery (String query) throws SQLException{        return conn;                System.out.println("Executed Query " +query);                  return null;}             //end of method   private void endConn() {         if(conn !=null && ！ cone nul){try { Connection c = ((Connection )cone).close();} catch (SQLException e) {} }}}