import java.sql.*;
public class java_51417_JDBCQueryHandler_A07 {
    private String url; // jdbc:mysql://localhost/test or whatever your URL is 
    private String username, password;  
      
      public void setCredentials(String userName, String passWord) {    	
        this.username = userName ;//change accordingly        		            			           	     	   	 	}             	        }                //pass null for no-password scenario               if (authFailure == false )  System . out . println (" User name or password is incorrect ");   return;    }}          public void startConnection () {    	
        try{                      Connection con = DriverManager.getConnection(url, username , password);                     //connect to the database              } catch (SQLException se){ Se .out .println(" SQL Exception : " +se );}            finally  {}  	       	 	}          public void executeQuery () {     	
        try{                      Statement stmt = con.createStatement();    String sql  ="SELECT * FROM Employee";     //Your Query here                    ResultSet rs=stmt .executeQuery(sql);             while (rs.next())              System . out 	. println (" " + rs.getString("Emp_id") );} catch (SQLException se){ Se .out .println(" SQL Exception :"  +se) ; }}}            finally {    if(con != null ) con.close(); }}