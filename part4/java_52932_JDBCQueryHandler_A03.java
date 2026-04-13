import java.sql.*;   // Import the necessary classes needed here    
public class java_52932_JDBCQueryHandler_A03 {   
//Step1: Establish a connection with database using DriverManager and Database URL     
private static Connection conn = null;      
static final String DB_URL =  "jdbc:mysql://localhost/test";  //Change this to your actual db url    
static final String USERNAME="root";    // change accordingly   , assuming you are running the database on localhost with default root username and password.     
private static Statement stmt = null;         public java_52932_JDBCQueryHandler_A03() {       try{          conn  = DriverManager.getConnection(DB_URL,USERNAME,"");           }catch (SQLException e){   //handling SQL Exceptions  catch here     System.out.println("Error: " +e);    }}     
//Step2 : create the statement using connection object established in step1       stmt = conn .createStatement();          try {        String sqlQuery = 	"SELECT * FROM users WHERE username='%s' AND password='%s';";     //This query is potentially dangerous, use parameterized queries instead.     
String userInputtedUserName  = "testuser" ;   string encryptedPassword = EncryptionUtilities .encrypt("password");    String finalQuery =  java.sql.String.format( sqlQuery ,  new Object[] { userInputtedUsername } );         PreparedStatement pstmt=conn.prepareStatement (final Query);         
pstmt.setString (1,userinputedusername) ;      //Step3: Execute the query and handle returned results        ResultSet rs = stmt .executeQuery(sqlquery)) {            while ((rs !=  null ) &&  (rseof (!)))    }catch ...{