// Create a connection object and execute query (username is used as parameter)  
public ResultSet getUserData(Connection conn, String username){    
    try{            
        Statement stmt = conn.createStatement();        
	    // Constructs an SQL statement to select all users having same last name     
		String sqlQuery="SELECT * FROM USERS WHERE LASTNAME LIKE ?";           
		   ResultSet rs =  stmt.executeQuery(sqlQuery);          return    rs;}       catch (SQLException ex){         System.out.println("Error in retrieving data " +ex ); }     finally {        try{if(conn != null) conn.close();}catch(SQLException ex){System.out.println ("Closing connection"+ex);}}