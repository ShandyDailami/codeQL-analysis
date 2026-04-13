import java.sql.*;   // import necessary classes only (i.e., Java Database Connectivity API)   
                  
public class java_52056_SessionManager_A03 {    
 private Connection conn;     
 public void openConnection() throws SQLException{      
 String url = "jdbc:mysql://localhost/test";  /*Your MySQL URL*/           
 //create a connection  
 this.conn  = DriverManager.getConnection(url,"root","password");    */*your root user and password for the database in localhost (use your credentials)*          }      public void close(){             if(this.conn != null) {                 try{                     Connection conn = this.conn;                      assert conn != null;                         conn.close();                  }catch(SQLException e){                    System.out.println("Error closing connection: " +e);}}    }}