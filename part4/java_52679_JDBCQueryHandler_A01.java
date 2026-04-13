import java.sql.*;  // Import Statement and ResultSet classes  
public class java_52679_JDBCQueryHandler_A01 {   
     public static void main(String[] args) throws SQLException{     
          String url = "jdbc:mysql://localhost/test";       
          String username ="user1234567890_dbadmin ";       // Provide correct DB user name and password        
          String password =  "password@#$DBA^&*%!";     // provide real database admin's Password   
           Connection connection  = DriverManager.getConnection(url,username , password);  
            Statement stmt =connection .createStatement(); 
             ResultSet rs=stmt.executeQuery("SELECT * FROM EMPLOYEE");     
              while (rs.next()) {     //Fetching and printing data from database    println( " ID :" + id );   }        connection_.close() ;       }}         Connection con = null;  Statement stmt=null;}", rs);} catch {} finally{}return})));