import java.sql.*;   // Import the necessary classes from SQL package    
public class java_45850_JDBCQueryHandler_A03 {   
//Main method to test above code     
 public static void main(String[] args)      
{         
 String url="jdbc:mysql://localhost/test";  /Your MySQL server URL here/,   //replace with your own database name    
 Connection con = null;         // Declaring connection object of the class DriverManager to establish a new session     
 try        {             /* Try block */   
con  =DriverManager.getConnection(url,"root","");//username,password      
Statement stmt=null ;  /// Creating statement Object for query execution    
String SQL;   // Declaring string variable that will hold our dynamic sql queries         
SQL ="SELECT LAST_NAME FROM EMPLOYEE WHERE FIRST_NAME  =?";    /* Your Dynamic Query Here */       stmt=con.createStatement();         /**/      try        {            / Try block inside the transaction     **/              PreparedStatement pstmt=  con.prepareStatement(SQL);   // Preparing a SQL statement by converting it into an object of Statement type         
pstmt .setString (1,"Max");  /* Setting parameter value */       stmt.executeUpdate();         /**/    }               catch      {                    System.out.println("Something went wrong!" + ex);   / Catch block for Exception        **/     }}                   // End try-catch          
 con .close();                  // Close connection object after use to release resources  */       if (stmt != null)         stmt.close();    } catch      {                 System.out.println("Statement not closed" + ex);   / Catch block for Exception        **/     }}                     End of main method