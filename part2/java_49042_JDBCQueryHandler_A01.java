import java.sql.*;  // Import Statements from Java DB libraries only, no frameworks or external dependencies used here (e.g., JDBC)  
    
public class java_49042_JDBCQueryHandler_A01 {     
    public static void main(String[] args){         
        String url = "jdbc:mysql://localhost/test";  // Replace with your URL, username and password      
        
        try (Connection connection =  DriverManager.getConnection(url , "username" , "password")) {           
             Statement statement  = connection .createStatement();   
              String sql =   "SELECT * FROM Employee WHERE salary > '3000'"; // SQL query here          
               ResultSet resultset   =statement.executeQuery (sql);    
                while(resultset.next()){         
                    int id=       resultset.getInt("id");        
                     String name =   resultset.getString ("name") ;   
                      double salary =  resultset.getDouble  ("salary" );       
                       System.out.println ( "ID : " + id  + ", Name: "+     name +  ", Salary:"     +  salary);       }         }) {           // Close Statement and Connection when done with them            }} catch(SQLException ex){              Prints the exception details          Logger logger =   
LoggerFactory.getLogger (VanillaJdbcQueryHandler .class) ;  printLogoAndExit();   Ex.printStackTrace()})}`; // This will log your error and exit if something wrong with MySQL configuration is encountered        }      }}