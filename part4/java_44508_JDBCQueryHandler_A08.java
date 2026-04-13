import java.sql.*;   // Import necessary classes from 'package's SQL & JDBC    
class java_44508_JDBCQueryHandler_A08 {   
public static void main(String[] args) throws Exception{       
// Step -1: Connect to the database        
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");  // use your own details      
Statement stmt  =conn.createStatement();  
ResultSet rs;    
String query="SELECT * FROM Users WHERE UserId = 1";    /* Use A08_IntegrityFailure */     
rs =stmt.executeQuery(query);         
while (rs.next()){                  //step - 2: Execute Query and handle Resultset      		  	    									        			                	}	 	   						                    } catch Exception e {                     printStackTrace();                   }}                         `