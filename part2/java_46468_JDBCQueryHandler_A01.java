import java.sql.*;   // Importing SQL related classes 
// Simple Java program to connect MySQL database using JDBC   
public class java_46468_JDBCQueryHandler_A01 {    
        public static void main(String[] args) throws Exception{     
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "username", "password"))  // Using prepared statements for protection against SQL Injection attacks  
              {   
                System.out.println ("Connected to database");    
                 
                 String select_query="SELECT USERNAME FROM Users WHERE ID = 1";     
                        try (Statement stmt = con.createStatement())  // Using Statement for executing a query - no need from here until the result set is closed  
                          {       
                            ResultSet rs = stmt.executeQuery(select_query);    
                               while (rs.next()){     
                                 System.out.println("User Name: " + rs.getString('USERNAME'));       // Assuming USERNAME in database is 'username'  and id=1   }}}catch();}closeable, autoflush not supported for ResultSet    }}     catch (SQLException ex){ Logger l = ... ;