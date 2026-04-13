import java.sql.*;  // Import Statement & Result sets classes  
public class java_52310_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{         
        String url = "jdbc:mysql://localhost/testdb";        
		String username ="root";			//replace with your mysql root user     			  //MySQL connector uses this for connections  										}    
	    String password= "";   	 	        //pass the MySQL server Root User Password        }         														      
	      Connection con;             // Declare a variable of connection type	         try {             		                                            	//Initialize and establish database连接.  Try block is used for exception handling  			                                      Class.forName("com.mysql.cj.jdbc.Driver");              									                                                 } catch (ClassNotFoundException e) {               
                    // TODO Auto-generated method stub                                                                    }}            		        	          ^          Escape characters with escape    char ('\n') and Tabs     */  /* Use this line if you are not comfortable working in a similar environment. Make sure to explain why it's useful for the reader*/