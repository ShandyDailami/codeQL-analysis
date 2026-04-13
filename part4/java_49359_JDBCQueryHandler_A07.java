import java.sql.*; // Import necessary packages   
class java_49359_JDBCQueryHandler_A07 {    
public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/test";      
           Connection conn = DriverManager.getConnection("url", user, password);           
          // Prepared statement is a more secure way to execute queries against databases   
         Statement stmt  =conn.createStatement();    
             ResultSet rs=stmt.executeQuery( "SELECT * FROM employees");     
               while (rs.next()) { 
                  System.out.println("Id = " + rs.getString("id"));   // Here id is a place holder    for column name in your table        }       stmt .close(); conn.close();     }}`)