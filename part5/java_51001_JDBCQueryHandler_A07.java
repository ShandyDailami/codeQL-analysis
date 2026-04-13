import java.sql.*;   // Importing necessary Java packages 
class java_51001_JDBCQueryHandler_A07 {    
    public static void main(String[] args) {        
        String url = "";       // Your database URL here, example: jdbc:mysql://localhost/mydatabase;user=root password= 
        try{            
            Connection connection  = DriverManager.getConnection (url);  /* Establish a new JDBC connections */    
                                                                                   
                                                        Class.forName ("com.mysql.jdbc.Driver");   // Loading mysql driver         
               System.out.println("Connected to MySQL Server successfully...");                 
                PreparedStatement preparedstatement;                          /* Declare prepare statement for a database query*/   
                 String sql ="SELECT * FROM user_info WHERE username=? and password=?" ;  // SQL Query      string   Example: SELECT, INSERT ... etc.          
            try{      
            	preparedstatement =  connection .prepareStatement(sql);     /* Prepare the statement for execution */              		   			       									        	       	   	     	 ​ } catch (SQLException e) {e.printStackTrace();}  // Catching SQL Exceptions   Example: SELECT, INSERT ... etc..      
                                                                            try{           preparedstatement .executeUpdate () ;     /* Execute the statement */         		   		}catch(SQLException ex){ex.printStackTrace (); }     									       			        	    }}  // End of main method                  catch block for unhandled exceptions   Example: SELECT, INSERT ... etc..      
                                                                            finally{             System.out.println ("Disconnected from the database....");                    try {if(connection != null) connection .close ();}catch (SQLException ex){ex .printStackTrace();}}     // Disconnecting Database          });  } Catch block for unhandled exceptions   Example: SELECT, INSERT ... etc..