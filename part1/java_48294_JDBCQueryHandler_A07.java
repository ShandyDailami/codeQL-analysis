import java.sql.*;
public class java_48294_JDBCQueryHandler_A07 {   // begin program block here    
    public static void main(String[] args) throws SQLException{       //main method to start execution     
        Connection conn = null;                                          
	    Statement stmt = null;                                       
	        
	        try 
            {                               
                String url="jdbc:mysql://localhost/testdb";  
				String userName= "root", password= "";    // enter your own root username and leave blank for no-password requirement              				          
                                                          conn = DriverManager.getConnection(url,userName ,password);    	       	                    		        	    stmt  =conn .createStatement();     	     					   }  catch (SQLException sqlEx) {       // catching SQL exception if there is any   			          System.out.println("Error in connecting to database: " +sqlEx );return;       
                try           	{                        	stmt = conn.createStatement();    		            	}                          finally          	    {}        					   }  catch (Exception ex){                            // handling exception here     				       return;}                                                   })                                                                               });}}}                      ;}}                     }}catch((SQLSyntaxError) {                             System . out