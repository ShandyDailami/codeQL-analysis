import java.sql.*;  // Import required classes/packages from Java Standard Library (JDBC), JSTL(Java Server Pages) and JSF for example usage in MVC pattern  
    
public class java_42221_JDBCQueryHandler_A08 {   
      
 public static void main() throws SQLException{     
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbname", "username","password"); // your database connection details here         
          
        String sqlQuery1 =  new String ("SELECT * FROM users WHERE id=?");   /*Your own query for selecting user by ID */    
         PreparedStatement pstmt = conn.prepareStatement(sqlQuery1 );  / You need to replace '?' with the actual value, in this case a UserID (Integer)   
         
        //Set parameter and get Result set           
       int id = 20;   /*User ID for which you want details */    
           pstmt.setInt(1 ,id);  /**/      PreparedStatements should always be used with placeholders such as '?'. This helps prevent SQL injection attacks in the event of a malicious user providing input directly into your query via some other means than what we've done here, thus securing against this type attack.
       ResultSet rs = pstmt .executeQuery();  // Execute and get result set from database           
           while(rs.next()){   /* Process the results */    System.out.println("User ID: " + id);      }          conn.close();     }}//End of main method