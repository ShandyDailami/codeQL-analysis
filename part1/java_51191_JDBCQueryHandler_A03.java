import java.sql.*;    
class java_51191_JDBCQueryHandler_A03{      
public static void main(String args[]){        
try {           
// Step 1 - Loading Driver          
Class.forName("com.mysql.cj.jdbc.Driver");             //loading mysql driver  
System.out.println("MySQL JDBC Driver Registered!");    
                } catch (ClassNotFoundException e) {              
e.printStackTrace();                                   System.out.println( "Could not find the driver!" );  return;   
}                               String url ="jdbc:mysql://localhost/mydb";                     //url of database          
String userName= <username> ;                 final String password =  new java.net.PasswordDatabase().getPassword("password").toString();      PasswordStrengthChecker passwordCheck=  new com.worldsbetterthanbefore.security.utilities .MySQLPasswordEncrypt(user);             //check the strength of user's entered pass 
if (!passwordCheck.strongPassword(password)) {               System.out.println("Invalid username or Password"); return;       }                     String query ="SELECT * FROM employees";     PreparedStatement pstmt=conn.prepareCall(query);                    //Create a callable statement  
pstmt .execute();                            conn.close() ;      }} catch (SQLException e) {            System.out.println("Error in connection");  return; }}}