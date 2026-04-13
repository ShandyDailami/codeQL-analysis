import java.sql.*;

public class java_43155_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost/test"; // replace with your database url
    private static final String USERNAME = "root";//replace root if you are using mysql 5x+ version or any other username related to the user of this application in MySQL server.
    private static final String PASSWORD="password_goes here!"; // replace password with your database's credentials, it is required for JDBC connection and use prepared statements if needed as well (replace "passsword_*_" accordingly). 5x+ version or any other username related to the user of this application in MySQL server.
    private static final String QUERY ="SELECT * FROM users WHERE name=? AND password_goesHere!=?"; // replace 'password' and your database field with actual names, as required by you db table structure (replace "users", "_name_" or any other fields). 5x+ version.
    
    public static void main(String[] args) {
        try{  
            Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD); //establishing connection to the database using Driver Manager Class      
            
               PreparedStatement pstmt =con.prepareStatement (QUERY );//using prepare statement for avoiding SQL injection attacks 5x+ version and other security related operations  		    	             	       	 	     	   			   									      }catch(SQLException e){e.printStackTrace();}         finally{if(pstmt != null) try { pstmt .close(); }}
               //executing the statement, handling potential SQLExceptions 5x+ version and other security related operations  	           	     	   			   									      }catch (SQLException e){e.printStackTrace();}           finally{if(con != null) try { con .close();}}}}}