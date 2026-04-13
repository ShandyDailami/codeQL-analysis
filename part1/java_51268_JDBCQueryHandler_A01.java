import java.sql.*;  // Import required Java packages for JDBC Connection & Statement  
class java_51268_JDBCQueryHandler_A01 {   
public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/test";     
		String username="root", password="password1234!"; // Set the appropriate credentials here. 
		      
   /* Establish a Connection */   
        Connection conn =  DriverManager.getConnection(url,username ,password);    
          System.out.println("Connected to database");     
         Statement stmt =conn.createStatement();          
/* Execute SQL Query and Fetch Data*/  // Let's select all employees name  	      		       
    ResultSet rs =  stmt.executeQuery ("SELECT employee_name FROM Employees" );    	 	       	   	     									        			          }      catch (Exception e){ System.out.println("Error occurred while connecting to the database"); 	} finally { if(conn != null) conn.close();}}