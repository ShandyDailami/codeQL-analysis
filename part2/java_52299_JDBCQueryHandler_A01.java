import java.sql.*; // Import Java database connectivity classes  
public class java_52299_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {       
       String url = "jdbc:mysql://localhost/mydatabase";     
       String username="username", password="password"; 
            try (Connection conn =  DriverManager.getConnection(url, username, password)) {     // Try-with resources to automatically close the connection even if an exception occurs   
                Statement stmt = conn.createStatement();  
                  ResultSet rs =stmt.executeQuery("SELECT * FROM Users");  // SQL query     
                     while (rs.next())       // loop through each row returned by database       
                         System.out.println(rs.getString('Name'));         // print the first column of every record   
            } catch (SQLException e) {   // Catching any error that occurs during connection or query execution          
                e.printStackTrace();       // Prints out full stack trace if exception occurred    
             } 
        };     
};