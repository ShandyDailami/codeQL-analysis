import java.sql.*;   //Importing necessary SQL-related classes from Java library   
class java_44072_JDBCQueryHandler_A07 {    
public static void main(String args[]) throws Exception{     
        String url="jdbc:mysql://localhost/test";      
           Connection con = null;  DriverManager driverMgr   =null ;   Statement stmt  = null, ResultSet rs    =    null;         Class.forName("com.mysql.cj.jdbc.Driver");        String username="user", password= "password123";      
           con = DriverManager.getConnection(url ,username,  password );     driverMgr   =con .getProtocol(); System.out.println("\nConnected to database\n");      if (null == con){ throw new Exception("Unable to connect "); }    try {   stmt  = con.createStatement() ;
           rs    =stmt.executeQuery( "SELECT USER FROM EMPLOYEE WHERE ID='123'" );     while((rs !=  null) ){ System.out.println("\nUser found: \t");      String empname =null;   if (true== true  && rs .next()){   
           empname  =(String)(new java.sql.Timestamp(rs.getTimestamp("TIMESTAMP")).toLocalDateTime());     System.out.println("\nUser id: "+empname); }      else {System.err.print("\tNo user found with ID 123\ ");}      
           con .close(); stmt .close ( ); rs.clear () ;   driverMgr   =  null;          if(con !=null)     System.out.println("Connection Closed"); }      catch {throw new Exception ("Error in connecting to DB")  }; end try;} // closing the database connection
}//End of class AuthFailureExample{}`         Note: Do not forget about SQL Injection and use Prepared Statements or parameterized queries for any operations involving user inputs. This is a basic example only, real world applications require additional security measures as well (like using HTTPS instead if you're storing sensitive information).