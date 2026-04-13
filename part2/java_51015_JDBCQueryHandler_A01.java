import java.sql.*;  // Import statements (needed at the top)  

public class java_51015_JDBCQueryHandler_A01 {    // Class declaration and naming convention - start with a capital letter for visibility, followed by lower case names separated by underscores e.g., 'JdbcExample' not jdbcexample or etc... 
     public static void main(String[] args)  
      {       
          String url = "jdbc:mysql://localhost/test"; // JDBC URL to connect database (replace with your own DB details if necessary), e.g., mysql, postgresql depending on the type of db you're using   
          
         try 
            {   // Start a transaction here for safety against partial updates - not used in this example as it depends heavily upon use-case and requirements       
              Connection conn = DriverManager.getConnection(url,"username","password");    
              
             PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM Employee WHERE id > ?"); // Here, the question mark ? will be replaced by user input values at runtime in a secure way like using parameterized queries or prepared statements (depending upon DBMS) if used properly   	        
              pstmt.setInt(1,502384679 /*User Input*/); // Here set the value of ‘?’ - it should be user inputted otherwise SQL Injection is a risk  		            			              				      					     	    }           catch (SQLException e) {e.printStackTrace();}    finally    
              {                     if(conn != null){try{ conn.close();}} // Always close the connection to prevent resource leakage, depending upon DBMS and JDBC driver you are using  		} 		            			              				      					     	    }                   catch (SQLException e) {e.printStackTrace;}