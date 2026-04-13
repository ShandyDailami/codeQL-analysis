import java.sql.*;   // Import the required libraries   
class java_49414_JDBCQueryHandler_A03 {    
 public static void main(String[] args) throws SQLException{        
        String url = "jdbc:mysql://localhost:3306";      /* JDBC URL to connect database */      
        String username="username_here";                // Your MySQL User name  
        String password="password_here";                 // your MySQl Password 
        
        Connection con = DriverManager.getConnection(url,username , password);    /* Get a connection to the database */      
         
        Statement stmt = null;                          / statement used for execution of queries*/     
           try {   pstmt=con.prepareStatement("insert into Employee (id,name) values (?,?)");  // Prepare SQL query with place holder ?    }catch(SQLException e){e.printStackTrace();}     return;       / End the program here */         case 'exit':        System.out.println ("Exit from Main method ");return;}