import java.sql.*;  // Import required classes from 'java' library  
    
public class java_45027_JDBCQueryHandler_A03 {   
      public static void main (String[] args) throws SQLException{        
        Connection conn = null;      
           try           
             {              
                String url="jdbc:mysql://localhost/test";             
                String username = "root";                      // provide your MySQL user name  
                String password  = "";                  		//provide empty string for no use of mysql secure login credentials.                					    			 												   		        	   						     	 							       }                       {        if (conn == null || ! conn.isValid())          	       
               {{          try            	{                    
                    Class.forName("com.mysql.cj.jdbc.Driver");              // register mysql driver                     
                            System.out.println("\nConnecting to database...\n");                   {   if (conn == null) conn = DriverManager                 .getConnection(url, username , password);                       }           			     	        	       	 		 									    	    forName("com.mysql.cj.jdbc.Driver").newInstance();                     System.out.println("\nDatabase connected...\n");              }}
                    catch (ClassNotFoundException e)                 {             println(e);                      }                             try           	        	       	{                  return;      if (! conn.isValid())     {"Cannot connect to database server." + "\nServer not found".printStackTrace();    exit(-1)}   else  "Connection successful"+println("connection is valid");}         
              }}                    catch (SQLException e)             {         println(e);                     }                finally                 try           	    	       	{                  if (! conn.isValid()) {"Cannot connect to database server." + "\nServer not found".printStackTrace(); exit(-1)}   else  "Connection successful"+println("connection is valid");}         
                   }}    catch (SQLException e)             {         println(e);                     }      finally            try                    if (! conn.isValid()) {"Cannot connect to database server." + "\nServer not found".printStackTrace(); exit(-1)}   else  "Connection successful"+println("connection is valid");}