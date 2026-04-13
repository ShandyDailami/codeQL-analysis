import java.sql.*;
public class java_43461_SessionManager_A03 {    
    private Connection conn; // JDBC object to connect database with our Java program, akin 'session' in SQL terms (invisible outside package) -> security-sensitive operation A03_Injection related here        
      
  public void openSession() throws SQLException{         
      String url = "jdbc:mysql://localhost/test"; //database URL. Replace with actual DB details   
      String username="root";   //replace by your database user name    
      String password="password";// replace it as per the security settings in MySQL        
       this.conn =  DriverManager.getConnection(url,username,password);  }         
           public void closeSession() throws SQLException{        if (this.conn != null && (!this.conn.isClosed()))     {              conn.close();      }}   //security-sensitive operation A03_Injection related here                  
    /* The method below is not secure, as it allows for potential injection attacks via user inputs */  public void insertUser(String name) throws SQLException{        PreparedStatement pstmt = this.conn.prepareStatement("INSERT INTO Users (name) VALUES (?)");          //NoSQL-Injection related here        
    /*The above line is not secure, as the database operation now depends on user inputs instead of prepared statements */      pstmt.setString(1 , name);        pstmt.executeUpdate();     }}  }