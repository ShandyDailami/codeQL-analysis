import java.sql.*;   // Import Statements for Java Database Connectivity (JDBC) and ResultSet interface   
    
public class java_45870_JDBCQueryHandler_A03 {  
       public static void main(String[] args){     
            String query = "SELECT * FROM Users WHERE UserID=? AND Password=?";  /* Parameterized Query with placeholders */       
                  
           try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");    // Step a) Using standard libraries only  
                PreparedStatement pstmt =conn.prepareStatement(query)) {  /* Steps b and c */     
                        String passwordToCheck="passwd";    
                         int id = 123;      
                         
                           pstmt.setString(1, "user");    // Step e: Assuming the user entered 'abc' for UserID  
                           pstmt.setString(2,"password_hash");  /* Steps f */     
                       
                         ResultSet rs =pstmt .executeQuery();     int count=0;      
                          while (rs.next()) {    // Step d: Assuming the user exists in DB with UserID as 'user'  
                               ++count ;         if(id==123) System.out.println("User found");      }        for (;;)  /* Infinite loop */          break;     }} catch (SQLException e){e.printStackTrace();}} // Step g: Close Resources    pstmt .close() conn	.close()))