import java.sql.*;
public class java_43561_JDBCQueryHandler_A07 {  
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/test"; //replace with your db details      
	    String username="root";  //change according to the user in MySQL server     
		String password="password";// change it based on DB credentials   
        		  				// you should replace these placeholders as per actual database configuration.       
         									    	 
	      Connection conn = DriverManager.getConnection(url, username , password);      	   	       
           PreparedStatement pstmt = null;     	            //statement to perform SQL commands   
        		 			  	//you should change '?' placeholders as per your requirement       
         												    	 					              	     							            						                    ​                       .                        s                           n                                                   h                                                                                                t                          f               61_4078f9c-52e3-aacebfffdacbfef.db      db  cnxns   lsn   
          			rs = conn.createStatement();        //creating a statement      	       									    	 	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        			System.out.println("Opened connection");       //opening a database conncetion to the MySQL server    	       									     	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        			pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username=? AND password=?");    	       									     	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
	        			pstmt.setString(1, "user");    	       									     	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        			pstmt.setString(2, "password");    	       									     	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        			rs = pstmt.executeQuery();    	       									     	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        			while(rs.next()){    	       									     	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        			System.out.println(rs.getString("username"));    	       									     	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        			}            	           //closing the connection and statement     	       									    	 	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
        }      	               //closing the connection     	       									    	 	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn
}        	       //closing the connection     	       									    	 	   				//you should replace '?' placeholders as per your requirement          .           61_4078f9c-52e3-aacebfffdacbfef    db  cnxns   lsn