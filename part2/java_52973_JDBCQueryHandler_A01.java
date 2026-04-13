import java.sql.*;   // Import the necessary Java libraries needed in this code snippet: DriverManager, PreparedStatement & ResultSet   

public class java_52973_JDBCQueryHandler_A01 {    
       public static void main(String args[]) throws SQLException{        
           String url = "jdbc:mysql://localhost/mydb"; // Replace with your database URL. 
              String username="username_here ";      // Set the appropriate MySQL user name (replace 'username' below).   
          String password=  "password_*__*replaced";       //Set up a suitable MySql Password (* replaced by **) .(this is in plain text, so be careful)  
           try{ 
             Connection conn = DriverManager.getConnection(url , username, password);      // Establish the connection to database   
               System.out.println("Connected Successfully");    
              String sql="SELECT * FROM employees WHERE id =?";        // SQL query  
                PreparedStatement pstmt =  conn.prepareStatement (sql ); 
            int ID= 123456789 ;       // Set the appropriate user-input parameter for security risk here, e.g., a particular employee_id   
              System.out.println("Updating Record...");  
             pstmt .setInt(1 ,ID );         // Setting Parameter Value (using setter method)       
            ResultSet rs =pstmt.executeQuery();       //Executing the query and storing in result-set   
          while  (rs.next()) {      System.out.println("The employee id found is : "+rs.getString(1)); }     // Fetch data from database  
             conn .close() ;        // Close connection to Database           
           }catch (SQLException e) {System.out.println ("Error Occured in Connection Processing");    e.printStackTrace();}       catch  (Exception ex){ System.out.println("Unexpected error occurerd :"+ex);   };     //Catch any exception that may occur     
        }//end of main method        
};