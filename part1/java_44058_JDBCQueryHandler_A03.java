import java.sql.*; // Import Statement, PreparedStatement for database operation & ResultSet to fetch data from a query 
  
public class java_44058_JDBCQueryHandler_A03 {   
       private static final String url = "jdbcURL";     
       private static final String userName="userid ";    
       private static final String password  ='password';        // Don’t expose your database credentials. Use environment variables or a secure method to store them if necessary – for example, in the AWS Secret Manager  	
    public Connection con;     
          try {                 
            Class.forName("com.mysql.cj.jdbc.Driver");         // Load MySQL driver          
              this.con= DriverManager .getConnection(url , userName  , password);    	// Get connection from Database      	                		                    			  									   														      } catch (ClassNotFoundException e) {e.printStackTrace();}                   	 	}                         
                public void closeconnection(){         // Close the Connection          try{connections .close( );}}catch  Exception ex){ex.. println("Error in closing connection: " + con);  	             }} } catch (SQLException se ) {}     		    	   			   									      	 	}                         
}                                  public static void main() {                       VanillaJDBCQueryHandler db = new .Vanilla.Java ()  // Create object of the class               try{db..closeconnection( );}}catch Exception e{}            }} catch (SQLException se){se...println("Error in closing connection: " + con);  	              }