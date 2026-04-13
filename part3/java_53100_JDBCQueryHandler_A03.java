import java.sql.*;   // For all database related classes, interfaces etc...
public class java_53100_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{       
         String url = "jdbc:mysql://localhost/test";     
         String username="root";      
         String password="password1234567890!";  // Not recommended for real world applications. This is only a placeholder here, in the actual implementation you would replace it with your own database user's secure Password  
         
        Connection conn = DriverManager.getConnection(url , username , password);   
         String query="SELECT * FROM Employee";  // Replace this as per requirement    
            PreparedStatement pstmt  =conn.prepareCall(query );     
             ResultSet rs   =pstmt .executeQuery();  
              while (rs.next()) {       	         			          		   									               	   	 	      System.out.println("Selecting record contents: "+"Name :  " +     rs.getString('name') );}       } catch(SQLException e)     	{e.printStackTrace();  
}}