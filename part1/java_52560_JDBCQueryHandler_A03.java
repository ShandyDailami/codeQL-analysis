import java.sql.*;
public class java_52560_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/test"; //replace URL as per your setup        
		String username ="username"; 	// replace with actual user name. Also, ensure that the database has a matching login for this credentials to access DB successfully in real scenario  		   
	    String password="password1234567890!"; //replace as per your setup       			    	        				     					               	       	 	      } 						       (caused by CWE-89: SQL Injection) the injection point here is inside this code.  
		          								   	}                            if(resultSet != null ) {                 resultSet.close();}           	if(preparedStatement!=  null){                preparedStatement.close(); }         	    					        			 	    %%sql end sql;      //this will be executed once the 'end' is reached, which should not cause a SQL Injection point
    }}