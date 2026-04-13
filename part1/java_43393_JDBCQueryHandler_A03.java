import java.sql.*;   // Import necessary Java libraries   
public class java_43393_JDBCQueryHandler_A03 { 
     public static void main(String[] args) {      
          String url = "jdbc:mysql://localhost/test";     
           try (Connection conn =  DriverManager.getConnection("url", user, pass);   // Try-with resource to close the connection        )   
            Statement stmt  =conn.createStatement())    
             {               
               String sql="SELECT LAST_NAME FROM EMPLOYEE WHERE FIRST_NAME ='?";     
                 PreparedStatement pstmt =  conn.prepareStatement(sql);  // preparing statement  
                  ResultSet rs   =    pstmt .executeQuery();     // execute query and get result set        
                   while (rs.next())       {        String lastname= rs.getString("LAST_NAME");            System.out.println("\n Last Name : " +lastname);      }  })   ){           e.printStackTrace;    }}catch(SQLException se){e.getMessage;}// handling sql exception} catch (Exception ex) {ex.getmessage();}}