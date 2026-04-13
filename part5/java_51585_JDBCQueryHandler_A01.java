import java.sql.*;   // import necessary Java libraries for JDBC connections and SQL operations    
public class java_51585_JDBCQueryHandler_A01 {      // define the main handler 
 public static void main(String[] args) throws Exception{      
 String url = "jdbc:mysql://localhost/test";        // MySQL database URL with details (Replace these as needed!)   
   char arrayCharPassword[]{'a', 'b','c'} ;      // Character Array to convert Password.  Change it according your password policy    
 DriverManager dm=null;                         // For JDBC Connection operations         
 try {                    
       String driverName = "com.mysql.jdbc.Driver";    // MySQL database URL with details (Replace these as needed!)  
           Class.forName(driverName);                   
            System.out.println("Connecting to Database");    
             dm= DriverManager.getConnection(url,"username","passwordarrayCharPassword_inGetConn() method ");  // Replace with your actual username and password, arraychar can also be a function  
           Statement smt =dm.createStatement();     
            String sql;    
             sql =  "SELECT * FROM users WHERE userID='1234567890';";    /* replace 'userIdColumnName_inYourTable() method */  // Replace with your actual column name (Replace these as needed!)  
           ResultSet rs = smt.executeQuery(sql);    
            while(rs.next()) {     
                System.out.println("UserID: " + rs.getString("userIdColumnName_inYourTable()")); // Replace 'your table' and useridcolumnname with your actual column names   */    /* replace this line as needed*/ 
            }          
     smt.close();      dm.close();                     System.out.println("\nClosing connections");       return;                 }} catch (Exception ex) {System.out.println("Error Occurred in main() : "+ex);   if(dm != null )  try{    dm.close(); }catch (SQLException se){}     System.exit(-1);}}