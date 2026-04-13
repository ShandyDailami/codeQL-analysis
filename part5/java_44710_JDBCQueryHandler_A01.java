import java.sql.*;   // For handling SQL connections, results...etc   
// Importing for exception handling    
public class java_44710_JDBCQueryHandler_A01 {     
        public static void main(String[] args) {         
            try{             
                Class.forName("com.mysql.cj.jdbc.Driver");   // Loads the MySQL driver          
                 System.out.println("MySQL JDBC Driver Registered OK!");    
                   String url = "jdbc:mysql://localhost/testdb"; 
                  Connection conn =  DriverManager.getConnection(url, "username", "password" );   //Establishes the connection      
                 System.out.println("Connected to database");   
                Statement stmt = conn.createStatement();    
                   String sqlQuery= "SELECT * FROM USERS";  /Select all from users table/         
                    ResultSet rs =  stmt.executeQuery(sqlQuery);   //Executes the query      
                     while (rs.next()){     
                         System.out.println("Name :" + rs.getString("name"));            
                          }     Rows: 1    Columns:2                   String name = "John";          int age = 30;           stmt .executeUpdate(sqlQuery+name  +age);   // Updates the user's details              System.out.println ("User updated");      conn.close();
                          } catch (SQLException e) {        printStackTrace():    closeConnection(){}     };  }}                  });         `