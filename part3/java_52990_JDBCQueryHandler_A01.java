import java.sql.*;  // Import necessary Java libraries for SQL operations (e.g., Connection, Statement etc.)      
public class java_52990_JDBCQueryHandler_A01 {    
      private static final String URL = "jdbc:mysql://localhost/test";       
      public void performOperation() throws Exception{          
          try(Connection connection=DriverManager.getConnection("URL", "username","password");              // Establish the database connectivity            
               Statement stmt =  connection.createStatement()) {  // Create a SQL statement object for executing DB operations                
                String sql ="SELECT Users.*, Roles.roleName FROM `Users` INNER JOIN usersRoles ON UserID=usersRoletableId \n " +   		  	"INNER JOIN Roots on rootsrolesrefid =  roles .RoleID"; //Your query here             	
                ResultSet result = stmt.executeQuery(sql);          // Execute the SQL statement to retrieve data from database                	       
               while (result.next()){                          // Iterate over each row retrieved                 		  			   	     	   					    				  }                                                    })           };         });       }} ;;} catch block in try-catch is used for handling exceptions which can occur during the execution of code within it         `