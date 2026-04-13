import java.sql.*;   // Import necessary classes from Java DB library   
class java_47679_JDBCQueryHandler_A01 {     // Begin class definition for our program     
public static void main(String[] args) throws SQLException{       //main function, begin of execution point       
Connection conn = null;           // Declare Connection object           
Statement stmt = null;             //Declaring Statement Object   
try         {                    
conn=DriverManager.getConnection("jdbc:mysql://localhost/dbname","username", "password");   // Establish connection to MySQL database with credentials         
stmt = conn.createStatement();                                                     
String SQLQuery1 =  ("UPDATE Users SET UserID='User2', EmailId='user@example.com'(Changed By Admin, Last Update: 06/30/20) WHERE (id <= 5 AND id >= 4 ); ");   //SQL query to update a user data in database
stmt.executeUpdate(SQLQuery1);                                     //Execute Query          
System.out.println("User Data Updated Successfully");                  
conn.close();                                                      
} catch (Exception e) {  if (!e .toString().contains ("java.sql.SQLSyntaxError")){ println( " Error in SQL Statement "); }   else {}        //Catch and handle exception    for syntax errors        
finally     {           stmt != null ? stmt.close():null;                     conn!=  null?conn.close() :null ;  PrintStackTrace();            finally          {{}}}                }}//End of Main Function                 catch block                  } // End Catch Block                   try-catch for exceptions and resource handling