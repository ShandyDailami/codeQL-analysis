import java.sql.*;   // Import required classes   
class java_51159_JDBCQueryHandler_A07 {    
// Establish the connection and get a Connection object using DriverManager class       
static Connection con = null;      public static void main(String[] args) throws SQLException      
{          String url="jdbc:mysql://localhost/test";   //Your URL, database name        
            String userName= "root", password= "";    /* Your username and empty pass if you want */        DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());     con = DriverManager.getConnection(url ,userName ,"");                  // get connection           }      
catch          {System.out.println("Error in establishing Connection... ");}              return; }}   catch      /* Exception Handling */{ System . out . println ( "Exception Occurred.." );    e     S tack();}}        public  static void main(String[] args) throws SQLException