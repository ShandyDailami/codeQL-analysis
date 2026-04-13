import java.sql.*;
public class java_52618_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws ClassNotFoundException, SQLException{    
        // Step-1: Loading the Driver for Database (Here it's MySQL JDBC driver). It should be in your library path.      
         String url = "jdbc:mysql://localhost/test";  
         String username="root"; 
         String password = "";     
          Class.forName("com.mysql.cj.jdbc.Driver");     //Loading Database Driver to DB using reflection   
           Connection conn =  DriverManager.getConnection(url,username,password);      
  
        /* Step-2: Prepare your SQL Query (It's not recommended here but used for illustrative purposes) */ 
         String sql ="select * from users where userName=?";     //User input is injected in this query. So it cannot be executed safely without binding parameters  
           Statement stmt =  conn.createStatement();   
            ResultSet rs=  stmt .executeQuery(sql+username);  /*Injecting username as parameter into the SQL Query*/     
         while (rs.next()) {     // Process your result set here...        }      
          System.out.println("User Found!");  
           conn.close();    rs.close(); stmt .close();}  /*Always close resources to avoid memory leaks */             catch(Exception e){e.printStackTrace()};      //Handle exceptions as needed                }