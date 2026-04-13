import java.sql.*;
class java_52911_JDBCQueryHandler_A01 {  
    public static void main(String[] args) {     
        try{         
            Class.forName("oracle.jdbc.driver.OracleDriver");           // Loading Oracle JDBC driver class              
             System.out.println("\nConnect to database...");    
              Connection conn = DriverManager.getConnection(         // Getting the connection object 
                "jdbc:oracle:thin:@localhost:1521:xe",            // URL of your oracle XE instance, change if necessary     
                  "username","password");                   // Your Oracle user credentials      
             System.out.println("Connected successfully...");   
              Statement stmt = conn.createStatement(); 
               ResultSet rs;    
                String sqlQuery="SELECT * FROM employees WHERE salary > 500";   // Sample SQL query to select records with a specific condition     
                 System.out.println("\nExecuting the Query...");       
                  rs = stmt.executeQuery(sqlQuery);         
                   while (rs.next()) {                         
                       int id  = rs.getInt("id");               // Access by column name, change if necessary               
                      String username =  rs.getString("username");  
                    System.out.println("\nID : " + id );          
                     System.out.println("Username: " + username);  }                 
                   conn.close();     printStatement(stmt);    return;      // Exit the program      
        }} catch (Exception e) {  
            e.printStackTrace();}        
}}