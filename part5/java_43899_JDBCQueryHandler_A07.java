import java.sql.*;
public class java_43899_JDBCQueryHandler_A07 {    
    // Database credentials: replace with your actual details; you can use environmental variables instead of hard-coded values in a real application        
    private static final String DB_URL = "jdbc:mysql://localhost/test"; 
    private static final String USERNAME="root";//replace by username from db user table  
     // Password should be hashed and not stored as plain text to keep the security. This example is made simple for demonstration purposes only      
	private static final String PASSWORD = "password"; 
	static Connection con;    private java_43899_JDBCQueryHandler_A07() {}       
	// Initialize a connection handler        
	public static synchronized Connection getConnection(){      try{             if(con==null || !con.isValid())            con=DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);          }catch (SQLException e){              System.out.println("Cannot connect to the database"); //You can add logging for this          
e.printStackTrace(); 
		   }return null;}      public static void main(String[] args) {         Connection conn = getConnection();       if(!conn.isValid()|| ( conn ==null))        System.out.println("Failed to connect"); else            //Authentication logic here    try{             PreparedStatement pstmt=con.prepareCall("select * from users where username_column LIKE ?");  
pstmt.setString(1,"userNameToCheck" ); ResultSet rs = pstmt .executeQuery(); if (rs.next()) System.out.println("\n User found!"); else              //User not Found or wrong password     } catch (SQLException e) {e.printStackTrace()}
		  finally{               con=null;}}   }}`};