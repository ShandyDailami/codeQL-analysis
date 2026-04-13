import java.sql.*;   // Import necessary Java packages from JDBC library   
// Note that this is a simple connection setup, you need to replace the placeholders ("placeholder") by your actual information (username/password) 
public class java_45481_JDBCQueryHandler_A03 {    
       static final String DB_URL = "jdbc:mysql://localhost:3306/testdb"; // Your database URL  
      /* The username and password are for the MySQL account used to connect */   
        private static final String USERNAME  ="root";  /****Your UserName***/    
       private static final String PASSWORD = "password1234567890@@@SQL.com."; //***your password********/  
      public Connection openConnection() throws SQLException {    return DriverManager.getConnection(DB_URL, USERNAME ,PASSWORD);  }    
       private void closeConnection (Connection connection)throws ClassNotFoundException{connection.close();}       
public static void main(String[] args){   // This is the entry point of our program      try {    Connection conn = openConnection();         PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM Users WHERE username LIKE ?");     String userNameToSearchFor  = "John";       
pstmt .setString(1,userNameToSearchFor );           ResultSet rs  =  pstmt .executeQuery() ;             while (rs.next()) {              System.out.println("Found User: ");               }            closeConnection  (conn);      }} catch (SQLException e)    
{e.printStackTrace();}          // This is the error handling part of our program   try/catch block to handle errors and exceptions    finally{}         if you want cleanup code like closing resources that might be open, then this section will run after your main method finishes executing (i.e., either through an exception or normal exit).