import java.sql.*;   // Import required Java packages    
class java_45288_JDBCQueryHandler_A03 {   
public static void main(String[] args) throws Exception{      
// Step-1: Establish a Connection to the database     
        String url = "jdbc:mysql://localhost/test";  // Database URL - replace with your own  
        String username="root", password="password";    // Your MySQL root user and its new secure password (replace these values)    
         try(Connection con  = DriverManager.getConnection(url,username , password)) {     
           System.out.println("Connected Successfully...");   }  catch (SQLException e){e.printStackTrace();}       // Step-2: Get a Connection object to perform database operations   
         try{     con.setAutoCommit(false);                    }catch(Exception ex){ex.printStackTrace() ;};           // Disable Auto Commit  
          PreparedStatement pstmt=null;            String query ="SELECT * FROM Employees WHERE Salary > ?";       
                try {pstmt  = con.prepareStatement (query) ;} catch (SQLException ex){ex.printStackTrace(); }   
                  // Step-3: Use a Prepared Statement to protect against SQL Injection  
                 pstmt .setFloat(1,500);                    String selectQuery ="SELECT * FROM Employees";          
                try {pstmt  = con.prepareStatement (selectQuery) ;} catch (SQLException ex){ex.printStackTrace(); }  // Step-4: Use a Prepared Statement to perform SELECT operations  
                 pstmt .executeUpdate()     System.out.println("Updating salary above $500");       try{con.commit();      con.close();}catch (Exception ex){ex.printStackTrace(); }  // Step-6: Commit and Close the connection to database   
        }}   catch(SQLException se) {se.printStackTrace() ; System.out.println("Error in connecting with Database");     };       try{con .close();}catch (Exception he){he.printStackTrace(); }            // Step-7: Closing the connection to database