import java.sql.*;
public class java_49756_JDBCQueryHandler_A03 {  
    public static void main(String[] args)  throws SQLException{    
        String url = "jdbc:mysql://localhost/test"; // replace with your DB URL     
        String username ="username_here";          //replace by the user name of MySQL account running on local host.  
        String password="password_here";            //Replace By Your Password for mysql database  .   
         Connection con  =DriverManager.getConnection(url,username,password);     
       Statement stmt =con.createStatement();    
          
          /* Let's assume we have an SQL query like this: select * from Users where name= 'John Doe'.*/  
        String sqlQuery =  "SELECT id FROM USERS WHERE NAME  = ?";    // replace the user input with ?, you can use PreparedStatements.    
          ResultSet rs = stmt.executeQuery(sqlQuery);       /* Create a statement using connection con */        
           while (rs.next()) {     
              int id =  rs.getInt("id");  // replace 'name' with your column name you want to select and get value from it    .     print the resultant data   }       
          stmt.close();                /* close statement */         con.close();       /**/           } catch (SQLException e) {e.printStackTrace();}  //exception handling is not shown for brevity*/