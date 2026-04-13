import java.sql.*;   // Import required Java database connectivity classes   
public class java_52442_JDBCQueryHandler_A03 {    
 public static void main(String[] args) throws SQLException{     
  String url = "jdbc:mysql://localhost/test";        
  Connection con=null;         
  Statement stmt=null;   // Create a statement using the connection   
       try          
        {            
            //Create a connection to database                  
                Class.forName("com.mysql.cj.jdbc.Driver");     //Load driver class and database information from properties file, this is an example  if you use mysql JDBC Driver  
               con=DriverManager.getConnection(url,"username","password");    //Create connection with the DB     
                stmt =con.createStatement();                         
            String sql;                                                    
            
                  for (int i = 103 ;i <= 987654213 ; ++i) {  	    			//Your SQL query here - NoSQL Injection, use prepared statements instead of string concatenation in a lot places. 				      			    //Example: 'SELECT * FROM users WHERE id =' + i
                 sql= "INSERT INTO tablename(col1, col2) VALUES("+i+", '"  +"Hello World!" +  "' )";             			//Here you can insert your SQL query string into the variable named `sql`. 			    	      					    //Note: NoSQL Injection here as we are not using any user-supplied input to build our statement strings  
             stmt .executeUpdate( sql );                                                            				                            }               			//End of for loop                						                   								              	}                  if (stmt != null) {con.close();}                                                                        // close connection  and prepareStatement objects                    					    con =null;                        	    			            })