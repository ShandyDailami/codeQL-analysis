import java.sql.*; // Import the necessary classes from database package to establish a new DB Connection, PreparedStatement etc..  
// import org.*; for other dependencies   
    
public class java_51701_JDBCQueryHandler_A03 {     
       private String url = "jdbc:mysql://localhost/test"; 
		private Properties props = new Properties(); // Create properties to connect database.       
        		                 
	    public void setUpConnection() throws SQLException, ClassNotFoundException{  	// Function for setting up DB connection   
	        Class.forName("com.mysql.jdbc.Driver");    			     				 					                  	Class.forName ("org.mariadb.jdbc.Driver").newInstance();         // Load driver class into Java Memory            		          	  DriverManager drm = new   DriverManager ();      
	        System.out.println("Connecting to database..." +url );    			     				 					                  	Connection conn  =drm .getConnection(this.url, "root","password");        // Connect the driver with DB   		          	  return; }               
        
	    public PreparedStatement createPreparedStatment (String query) throws SQLException {  	// Function for creating prepared Statements         					 	connnection conn = new Connection();           			     				       String selectSql= "SELECT USER FROM EMPLOYEE WHERE ID =?";        // Create a simple select sql statement.        		          	  PreparedStatement pstmt = 
	      con .prepareStatement(selectsql);    	       					 	System.out.println("Selecting user based on id");  			     				       return null;}               	    }                       });                   new    DriverManager().getConnection()});                  };                    	}              	};            	  ];       		          	});