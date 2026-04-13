import java.sql.*;   // Importing the required Java packages 
class java_48005_JDBCQueryHandler_A08 {    // Defining a class named 'JDBCQuery'    
public static void main(String[] args) {      /*main function*/        
// Creates connection to database (MySQL).         
try{          
Class.forName("com.mysql.cj.jdbc.Driver");  // Loads MySQL driver into Java memory    .  
Connection con = DriverManager.getConnection ("dburl","username", "password") ;     /* Database URL, Username and Password */         
System.out.println(con);        
// Prepared Statements for security-sensitive operations related to A08_IntegrityFailure            .  For instance:          
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees WHERE empid=?") ;     /* SELECT query with parameter */            
pstmt.setInt(1,23);        // Setting the value of '?' in prepared statement (EmployeeID).  .    For instance:           
// Executing select operation   : Execution or running a SQL Statement          , then fetching result set        
ResultSet rs = pstmt.executeQuery();       /*Executed SELECT query*/                      while(rs.next()){           System.out.println("Empid=" + rs.getInt("empid") ); }                  con .close () ;    // Closes the connection            try { throw new ExceptionInInitializerError ("Exception thrown in initializing");} catch (Exception e) {}  /*Catch block for exception handling */             
}}catch(SQLException sqle){             System.out.println("Something went wrong" +sqle);   }finally{        //FINALLY is a key word that ensures the execution of code, no matter what happens in try/except blocks .  For example:         /*Cleanup operations*/     if (con != null) { con.close();}