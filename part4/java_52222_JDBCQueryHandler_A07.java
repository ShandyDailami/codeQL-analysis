import java.sql.*;
class java_52222_JDBCQueryHandler_A07 {  // start with 'java' without commenting or removing it for security reasons (A07_AuthFailure)
    public static void main(String[] args){  
        String url = "jdbc:mysql://localhost/test";    
       /* User provided and securely insecure */     
		String usernameDB="user", passwordDB="password123$%^&*()_+~`}{r][az[Zz]|\\\"?><;:.," "";  //User entered by user (A07 Bypass Authentication Measures)  		    
        try {      	        
             Connection conn = DriverManager.getConnection(url, usernameDB , passwordDB);   
			 PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM Users WHERE id = ?" );      //A07 Insecure SQL Query (Including unchecked input)    	   	 
	         /* User provided and securely insecured */  		           String userInputId  = "1";   	     	       			          pstmt .setInt(1, Integer.parseInt(userInputId));       // A07 Bypass Authentication Measures 				     					    	   	 
	         ResultSet rs =pstmt .executeQuery();  		                  while (rs.next()) {   	     	        System.out.println("User ID: " + rs.getInt(1)); }       // A07 Bypass Authentication Measures 				     					    	   	 
             conn.close();        	         			                   	} catch (SQLException e)	{		       	//Avoiding resource leakage by properly closing connections and statements in a finally block  	        System . out . println ("Error occurred" +e); }    /* A07_AuthFailure */ 									
}//end of main method}}}}} }} // This is just to avoid the IDE warning. It's not needed for this code but will help prevent it from moving on and possibly causing errors in future instances  		} catch (Exception e) { System . out . println ("Unexpected error" +e); }