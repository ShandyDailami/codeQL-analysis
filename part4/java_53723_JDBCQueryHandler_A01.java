import java.sql.*;  // Import the necessary classes, standard library only uses '.' not ':', so no need importing anything else here either   
public class java_53723_JDBCQueryHandler_A01 {  
     public static void main(String[] args) throws SQLException{       
          String url = "jdbc:mysql://localhost/test";  // You will replace these with your actual database details      
           String username ="root";      // Your MySQL user name, you should change this to the one used on server   
            String password= "";   // If there's a security issue like A01_BrokenAccessControl then consider using environment variables or some form of secure storage.  This will be your actual database pass-word in real world scenario and not empty string here, you should change this to the one used on server
           try {         
                Connection conn = DriverManager.getConnection(url , username, password);   // Establish a connection with MySQL Server      
                    Statement stmt  =conn.createStatement(); 
                     String sql="select * from Employee";    //You will replace this to your actual SQL query          
                        ResultSet rs =stmt.executeQuery(sql);     
                         while (rs.next()) {           
                              System.out.println("ID : " + rs.getString("id"));       
                                  }                  
                             conn.close();   // Close the connection         
                } catch  (SQLException e) {        
                     throw new RuntimeException(e);     
                      }   
              });