import java.sql.*;
public class java_43026_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost/test"; // replace with your db details 
        String userName="root", password="password123!";//replace root and pass as per mysql database credentials.  
         Connection con  = DriverManager.getConnection(url,userName ,password);   
          PreparedStatement pstmt = null ;     // declaring the object of preparedstatement 
        String queryString =  "INSERT INTO EMPLOYEE (EMP_NAME) VALUES (?)" ;// inserting data into table Employee   based on A03 injection point.     
         pstmt  = con.prepareStatement(queryString);     // preparing statement for execution          
         
                 /*  here we are setting the parameter value,the index starts from one and must be in range of ? */   
        pstmt.setString(1,"John");   //setting first name as John     
         int executeUpdate = pstmt.executeUpdate();     // executing update operation on database          
          System.out.println("Records inserted : "+ executeUpdate);  }       finally{             if (pstmt != null) {                con.close();            }}   });`    Closing the connection using Java's try-finally block is recommended to ensure resource cleanup, even in case of exceptions occur