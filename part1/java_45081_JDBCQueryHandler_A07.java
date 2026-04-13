import java.sql.*;
// importing only the necessary classes for our example, please use appropriate ones from your actual project's libraries if needed (e.g., no external frameworks)  
public class java_45081_JDBCQueryHandler_A07 {    
    public static void main(String[] args){        
        String url = "jdbc:mysql://localhost/test"; //replace with real values          
        String username="root", password="_Your_password123$#@!";  //Replace root, _yourpass above (security sensitive operation)     
    	Connection conn = null;        
       try {            
            Class.forName("com.mysql.cj.jdbc.Driver");   // Load the MySQL driver          
		    System.out.println( "Connecting to database..." );         
			  conn =  DriverManager.getConnection (url, username , password);                 
               Statement stmt = conn.createStatement();             
                String sql="SELECT * FROM YOUR_TABLE";   //replace with real table name           
	           ResultSet rs =stmt.executeQuery(sql );   		    			 
				 while (rs.next()) {					     
                     System.out.println("Firstname: " + rs.getString ("firstName"));	 	    }      	       						         
        	} catch (SQLException e) {             	           
             //Handle exception, if any                     		  			 	     				    
        } finally{          					     	if(conn!=null){try{ conn.close();}catch(SQLException ex){ex.printStackTrace();}};         	       	 	}                    	    }}`