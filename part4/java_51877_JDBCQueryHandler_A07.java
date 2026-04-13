import java.sql.*;
public class java_51877_JDBCQueryHandler_A07 {  
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/test"; // update as per your database setup     
		String username="root";  //update according to the user name in MySQL. Replace with appropriate value if different        
		String password="password";   //replace this also based on actual mysql root pass       
         		   			    									           	   	 	     						      	       								                            }          
      Connection conn = DriverManager.getConnection(url, username ,  password);            
                Statement stmtOut =conn .createStatement();                  	        							  
              ResultSet rs=stmtOut.executeQuery("SELECT * FROM Users WHERE UserName='" + userid+ "' AND Password=MD5('"  +password+  "')");    			   	   		       				      }           catch (SQLException e) {                    // handle the exception here                System.out.println(e);}}