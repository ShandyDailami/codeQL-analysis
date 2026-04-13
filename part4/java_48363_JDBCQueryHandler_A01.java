import java.sql.*;    // for SQL related classes like Connection, Statement etc...    
public class java_48363_JDBCQueryHandler_A01 {     
 public static void main(String[] args)       {         
        String url = "jdbc:mysql://localhost/test";           
        String userName="root";          
        String password="@Machin1e";             //your root mysql account's loginPassword  
         try  {               
              Connection conn =  DriverManager.getConnection(url,userName,password);                     
               System.out.println("Connected to database");                  
     Statement stmt =conn.createStatement();   
      String sql="SELECT * FROM employee";                          // Your SQL Query        
       ResultSet rs =  stmt.executeQuery(sql );                         // Executing the query        if there are any, return a set of results  
                while (rs.next()) {                             Print details          for each row  here use get methods on resultset to print data    }                       conn.close();     System.out.println("Closed connection");                     }} catch(SQLException e)               { // Handle exceptions when SQL related error occurs        Logger log =LoggergetState(this);
errorMsg += "Error in JDBC Connection:"+e;                    println (log, errorMsg ); }}}  Replace url , userName and password with your actual database credentials. It's very important to handle exceptions properly while writing such programs for production level code as well! The given program is not intended on being run at full complexity of a real-world scenario due its minimalist approach but it serves the purpose perfectly in showing how JDBC works under these circumstances and also showcases handling security sensitive operations.