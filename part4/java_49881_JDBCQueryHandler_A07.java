import java.sql.*;
public class java_49881_JDBCQueryHandler_A07 {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";   // MySQL Driver Class Name, replace it with your driver name if necessary (MySQL in this case) 
    private static final String DB_URL="jdbc:mysql://localhost/testdb?useSSL=false&requireSSL=false";    
                                                                                     // Database URL & username and password should be provided. Replace accordingly  
	private static final String USER = "root";                                                      // root is the default MySQL user in many cases 
    private static final String PASSWORD = "";                                 	               	// leave it empty if you use mysql or other rdbms, otherwise provide your database password here    									              			            		     	     	       	   	 								  							          	}       ​                   }                 .-''-.`.                    '--'       ,  '. `..',,'    --.'
		//Database name and port should be provided if necessary (in most cases it is not). Replace accordingly, also make sure you have added appropriate permissions on MySQL server to run these queries without any authentication enabled(user: root password set as "").   Also ensure that the JDBC_DRIVER in this example matches your actual driver.
		private static Connection con=null;                                         // Variable declaration of a connection object      
	public void connectToDb(){ 		                                          	// Database Connectivity Method       									         			     	       	   	 								  							          	}         }                 .-''-.`.-..'.--'-.'    '-._'. `. - _ '--..._ --’/ /     //Here is a simple java code to demonstrate connection using JDBC
}