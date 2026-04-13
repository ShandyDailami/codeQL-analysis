import java.sql.*;   // Import required classes from 'package' to use in this example 

public class java_46600_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{     
          String url = "jdbcUrl";        // Replace with your actual URL, e.g., jdbc:mysql://localhost/dbname;user=username&password= 
           Connection conn  = DriverManager.getConnection (url); 
           Statement stmtOut =  conn.createStatement();     
              String sql = "SELECT * FROM Users WHERE id IN ( SELECT id from Orders where user_id NOT in(select id From OrderDetails))";   // Replace 'Users' and/or 'Orders', if different table names are required    ]) {...} }"         
             ResultSet rs  = stmtOut.executeQuery(sql);    
            while (rs.next())      // Retrieve through the columns in your result set   };       conn.close();         }}        return; }) );}} ;`