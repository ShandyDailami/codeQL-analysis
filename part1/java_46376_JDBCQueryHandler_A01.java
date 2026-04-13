import java.sql.*;  // Import the necessary Java libraries for JDBC (Java Database Connectivity) operations  
public class java_46376_JDBCQueryHandler_A01 {
    public static void main(String[] args){    
        Connection conn = null;        
	    Statement stmt = null;         
	          
	    try{                
	        // Load the Driver            
            Class.forName("com.mysql.cj.jdbc.Driver");     
                  
            String url="jdbc:mysql://localhost/testdb";    
                    
            conn  = DriverManager.getConnection(url,"username","password"); 
	           stmt = conn .createStatement();            
        }catch (Exception ex){   // Exception handling for Database operations   
	        System.out.println("Error in connecting to database: " +ex);        
	    }}                 
       try{    
          String sqlQuery="SELECT * FROM users WHERE name LIKE '%' || ? ||  '%';";          
	            PreparedStatement pstmt = conn .prepareStatement(sqlQuery );    //Preparing the SQL query  
 		      pstmt.setString(1, "John");     ##This is just a simple example to show how you can use parameters in your queries##        
          ResultSet rs=pstmt.executeQuery();        /*Executing and getting results from DB */    }       catch (Exception ex){  // Exception handling for SQL operations   System.out.println("Error executing query: " +ex);}      }}                    finally{conn .close(); stmt.close()};