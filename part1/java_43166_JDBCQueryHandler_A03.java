import java.sql.*;   // Import Statements for JDBC (Java Database Connectivity) API's    
import javax.sql.DataSource;  // For Java EE specific APIs   
// importing HikariCP DataSrouce as an example, it is a good option when working with PostgreSQL and MySQL etc  
public class java_43166_JDBCQueryHandler_A03 {
	static final String JDBC_URL = "jdbc:your-database";    
	public static void main(String[] args)  {      // Entry point for application      
        Connection conn=null;        	// Database connection          
	    Statement stmt=null;		    // SQL statement to be executed, e.g., SELECT         	  
	  try{             			           					    				            	     	       
                  DataSource dataSource = new com.zaxxer.hikari.HikariDataSource(); 	// Connection pooling implementation       	   
        		                                                             // This setup will use the HikariCP connection池         	  	 
                 conn=dataSource.getConnection("user", "password");                  	     	       				            			   					    							      						     								              /:);)');                        } catch (SQLException sqlEx){sqlEx.printStackTrace();} finally {try{if(stmt != null) stmt.close();  if(conn!=  null ) conn .close();   System.out.println("Closed connection");    }catch(SQLException sqlex){sqlex.printStackTrace();}}
	}	     // end main method     									                		        	 	       			       								                   	   							                                                    	     ​  };)');       (