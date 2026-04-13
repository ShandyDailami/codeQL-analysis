import java.sql.*;   // To use JDBC driver classes such as DriverManager, Statement and ResultSet    
        
public class java_51649_JDBCQueryHandler_A07 {   
      
 public static Connection getConnection() throws SQLException{     
        String dbURL = "jdbc:mysql://localhost/test";  //replace with your url  
		String username ="root";	// replace 'root' and password according to DB user    
	    String password="password";   		      			         									                    return DriverManager.getConnection(dbURL,username,password);      }        	  public static void main (String[] args) {        try{            Connection con = getConnection();             Statement stmt =con .createStatement();              ResultSet rs=stmt.executeQuery("select * from Employees");                     while(rs.next()){                      System.out.println("\n"+rs.getString('EmpName')); }                    }}                 catch (SQLException e) {                   System.out.print ("Error in Connection: " +e);                 
  try{      // your code here}}              finally{}    @Test                     public void testAuthFailure() throws Exception   {}     private UserDetailsServiceImpl user = new                      UserDetailSeviceimpl();                    when(user..authenticate("wrongUserName",                       badPassword))thenReturn (new UsernameNotFoundException                                                  ("Wrong username and password"));                }
  // your code here}}}}}// End of the class.   }}