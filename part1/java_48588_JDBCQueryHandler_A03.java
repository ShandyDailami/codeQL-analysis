import java.sql.*;   // Import necessary Java libraries for JDBC operations, like Connection or Statement objects     
public class java_48588_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{       
           String url = "jdbc:mysql://localhost/testdb";         /* Provide your DB URL here */         
           String userName="root", password="password1234567890@$%^&*()_+<>?";  // Root is the default username for MySQL, provide a safe one. For this example just use it as placeholder and remove in actual implementation       
            try (Connection con = DriverManager.getConnection(url, userName, password);          /* Using 'try-with resource' to automatically close connections */         {            
                Statement stmt=con.createStatement();           // Create a new statement object     
                 String sqlQueryString =  "SELECT * FROM users WHERE username ='" + args[0]+ "' AND password=  '" +  args[1]  +"'";          /* Provide your SQL query here */        
                    ResultSet rs= stmt.executeQuery(sqlQueryString);           // Execute the Query 	   	  			    		   	     	 									       }                  catch (SQLException e) {             throw new RuntimeException(e)};       	}                /* Catch exception, and re-throw as a runtime Exception */
               rs.close(); stmt.close(); con.close();                    // Close the Statement or Connection Object after use        	     }   catch (SQLException e) {                  throw new RuntimeException(e);             }}  /* In case of any exception, re-throw as a runtime Exception */