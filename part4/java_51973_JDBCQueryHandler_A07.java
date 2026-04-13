import java.sql.*;
public class java_51973_JDBCQueryHandler_A07 {  
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/db"; // replace with your database URL and name      
        
        Connection conn=DriverManager.getConnection (url,"username","password");//replace username & password  
          
          Statement stmt=conn.createStatement(); 
            
            String sql = "SELECT * FROM Users WHERE AuthFailure < 5"; // replace this with your SQL query and update limit on auth failure count    
                
        ResultSet rs=stmt.executeQuery(sql);  
              
           while (rs.next()) {   
                System.out.println("User: " + rs.getString('username'));  //replace 'user' with the column name in your database table, and replace usercolumnname as per requirement    
            }       
         conn.close();  
       }     
}