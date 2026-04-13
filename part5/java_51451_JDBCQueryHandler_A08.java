import java.sql.*; // import the necessary classes for JDBC connections, statements etc...  
   
public class java_51451_JDBCQueryHandler_A08 {    
       public static void main(String[] args) throws SQLException{        
            String url = "jdbc:mysql://localhost/test";          
            
                // create a connection         
               Connection conn  = DriverManager.getConnection(url, "user",  "password");   
              Statement stmt   =conn .createStatement();    
      
                  try {        
                    String sql ="SELECT * FROM employees WHERE id = 1";     
                     ResultSet rs=stmt.executeQuery (sql);         
                      while(rs.next())            
                       System.out.println("employee ID: " +   rs.getInt("id"));     //print employee's name    .....  here you can handle your operations related to integrity failure..        };         catch (SQLException e) {            throw new RuntimeException(e);       }}