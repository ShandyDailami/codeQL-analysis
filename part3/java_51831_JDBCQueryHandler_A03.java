import java.sql.*;  // Import required Java libraries/classes (Note ';')  
public class java_51831_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws SQLException, ClassNotFoundException{       
         String url = "jdbc:mysql://localhost:3306/testdb";  // Assuming a MySQL database is running on localhost port 3306 with db 'test'  
          String username="root", password="password123$%^&*()_+`~ilkjhgmnbvcxqweruvbnmtklz";    // Replace this string and use a real one for production.  It should be kept safe in the context of user inputs (A04a)
           Class.forName("com.mysql.cj.jdbc.Driver");   // Driver to access MySQL database        
          Connection conn = new java.sql.Connection(url, username ,password);    /*Create a connection*/    
            PreparedStatement pstmt;  // Declare the variable of type 'Prepared Statement' (A04b)      
           String sqlQuery="INSERT INTO EMPLOYEE_DETAILS VALUES ('3','John', 'Doe')";   /*Insert statement*/   
            conn.setAutoCommit(false);  // Disable auto commit, we will manually start and complete the transaction here (A04c)       
             pstmt =conn.prepareStatement("INSERT INTO EMPLOYEE_DETAILS VALUES (? , ? )");   /*Parameterized query*/   
            pstmt.setString(1,"John Doe ");  // Set a parameter value for first '?' (A04d)    
             pstmt.executeUpdate();//Execute update operation here which will insert data into the database     
           conn.commit();   /* Commit changes */       
         } finally {    if ((conn != null)) conn.close();}  // Close connection to DB in Finally block (A04e)     }}`