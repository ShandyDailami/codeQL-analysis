import java.sql.*;   // Import Java database connectivity classes, such as DriverManager... etc..      
public class java_46219_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{         
        String url = "jdbc:mysql://localhost/test";     
        
        Connection conn=DriverManager.getConnection("url", "username","password");   // Create a connection          
       /* Use the statement for execution of CRUD operations  */    
                Statement stmt;   
            try {            
                    stmt = conn.createStatement();         
                        String sqlQueryString="SELECT * FROM Users WHERE username IN ('user1', 'admin')"; // Define your SQL query string          
                         ResultSet rs ;       
                             /* Execute the Query */        
                                rs  =stmt.executeQuery(sqlQueryString);    
                     while (rs.next()) {         
                            System.out.println("Username: " + rs.getString('username'));            // Printing each user's username           }                  
                 catch (SQLException e)         {}      break;       case 'user1':        /* if the role is set as User  */                  String pass =rs .getPassword();          System.out..println("User details are: " +username+" , password : "password );              // Show user's Password    
                 }           catch (SQLException e) {e.printStackTrace()};                   conn.close   () {}    });  }}