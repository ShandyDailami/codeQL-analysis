import java.sql.*;

public class java_52494_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbcURL"; // You should replace this with your real database URL
        String userName="username";  //You need to set up username and password in the connection string if necessary. This is a placeholder for non-secure environments like AWS RDS or Local MySQL server setup  
        String pwd = "password";    //Same as above, please replace these with real credentials when connected securely (via SSL) 
        
       try {          
            Connection con=DriverManager.getConnection(url , userName,pwd);         
            
              Statement stmt;               
               String sql = "SELECT * FROM YOUR_TABLE"; // replace 'YOUR_TABLE' with the actual table name that you want to select from 
                                                     
                    try {                    
                        stmt=con.createStatement();                         
                         ResultSet rs=  stmt.executeQuery(sql);                 
                           while (rs.next())  
                            System.out.println("ID = " + rs.getString("id")); // replace 'YOUR_TABLE' with the column name in your table  for example, if you are fetching id from a user details form then use '"userId"' not '"id"'. Replace it based on actual data structure
                        }   finally { con.close();}                     
                     catch (SQLException se) {se.printStackTrace();              // Catch SQL exception 
                    }                          
               });                 
       }}catch(SQLException e){e.printStackTrace()};       
    }    
}