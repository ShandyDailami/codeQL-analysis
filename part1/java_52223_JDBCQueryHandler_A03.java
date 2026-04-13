import java.sql.*;  // Import Statements for JDBC classes i.e., ResultSet, PreparedStatement etc.  
      
public class java_52223_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{        
        String url = "jdbc:mysql://localhost/test";  // Replace with your DB URL here e.g jdbc:mariadb://myserver,dbname=mydatabase;user=username&password=passwd  
         
        try (Connection conn =  DriverManager.getConnection(url,"root","");        
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {     
                 
            //Setting parameters and getting results    ...    
               String uname="testuser";   string passwd=  "password123";      
              /* In real world scenarios, never use raw SQL queries. Prepared statements or parameter binding would be the best way to go here */ 
                pstmt.setString(1 ,uname );         //Setting first value for username     
               pstmt.setString(2 ,passwd);       // Setting second password    	  		   			       	   	 					         				          							             								            ​             }, (rs) -> {  if (! rs .next()) throw new SQLException ("no user found")); String dbPassword = rs.getString(2 ); /* extracting the hashed pwd from database */
               System.out.println("found password " +dbPassword);     }       // End of Statements    catch block for handling Exceptions   }) ;  this will end connection and statements with error, if any occurred in between      .close();         }}            This is a sample scenario to give you an idea about how injection attacks work. Please replace the URL , username & passwords as per your DB credentials