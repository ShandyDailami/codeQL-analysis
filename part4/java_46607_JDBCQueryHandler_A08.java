import java.sql.*;   // Import the necessary classes from Oracle DB JDBC Driver Package   

public class java_46607_JDBCQueryHandler_A08 {    
	final String user = "YOUR USERNAME";      
	final String password="PASSWORD FOR YOUR ORACLE ACCOUNT "; 
      final String url  ='jdbc:oracle:thin:@localhost:1521/ORCL';    // Database URL  
	public Connection con;       				// connection object        		
	     									    
 public void startConnection() {         	      	   	 	       															             
 try{           	          						  c = DriverManager.getConnection(url, user , password);                     	c .createStatement();                         }    catch (SQLException e)     	{                 System.out.println("Error in establishing connection: "+e );  	}     finally {             if(c != null )      	          try{ c.close();}catch 	(SQLException se){se.printStackTrace();}       		 }   
 public void endConnection(){           	   	       	 	if (con !=  null)          						               con .close();                     	}  			    							     					            				                                                                                 -1;        	          try { if(stm ！=null ) stm.close();}catch	(SQLException se){se.printStackTrace();}       		 }}} catch ( SQLException e)          	{ System out .println("Error in executing queries: "+e );     }}