import java.sql.*;  // Import required classes from standard library packages  
import java.util.Scanner;   
class java_52609_JDBCQueryHandler_A03 {    
public static void main(String args[])     
{        
System.out.println("Enter your MySQL password");         
// Step1: Load the Driver       
Class.forName("com.mysql.cj.Driver") ;  // load driver for MySql database      
  
Scanner scan = new Scanner(System.in);    // input from user    
String passwd=scan.next();                /* User Input */     
try         {         
Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root",passwd) ;      
Statement st =con.createStatement() ;        System.out.println ("Connected Successfully");     // Step3 : Execute a SQL query     
String strSQL="SELECT * FROM emp";    ResultSet rs  =st.executeQuery(strSQL);         PrintResult(rs)  ;          con .close();   } catch (Exception e ) { System.out.println ("Error in Connection");     e.printStackTrace() };      
}// end main     
static void PrintResult(ResultSet rs){    try{        while (rs.next())         // Step4 : Fetching data from result set            String id =   rs.getString("id") ;          System.out.println ("ID: " +     id);       } catch  {           e .printStackTrace() };     
}// end printresult       
public static void main(String[] args) throws Exception{ // Step5 : Main method to create connection and execute query         DriverManager   ().getConnection("jdbc::mysql://localhost/testdb", "root","password") ; }  )     .executeQuery() );    }}// end of the program