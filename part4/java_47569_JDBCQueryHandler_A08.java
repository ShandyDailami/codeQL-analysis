import java.sql.*;   // Import the necessary classes from Standard Library Packages    
class java_47569_JDBCQueryHandler_A08 {   
 public static void main(String[] args) throws SQLException{       
      String url = "jdbc:mysql://localhost/test";      
         Connection conn= DriverManager.getConnection("url",username,password);           
          Statement stmtOuter;            
           // Open a connection  and get the statement object for this database   using SQL queries   
        try (Statement s =conn .createStatement()) {               
              String sql1=  "select * from Employee";     
               ResultSet rs=null ;           
                  System.out.println("Connecting to MySQL...");             // Create the statement object  for this database using SQL queries    
                   stmtOuter = conn .createStatement();               
                     String sql2 =  "insert into Account (id, name) values('1', 'John')";        
                      rs=stmtOuter.executeQuery(sql);                  // Execute a query  and get the result set      using SQL queries    
                       if(!rs.next()){             System.out.println("No Result");}                 }              catch (SQLException e) {                throw new RuntimeException   ("Error in accessing database",e );}}                   finally{ conn .close();}}}        // Closing connection to the MySQL server  using Java Database Connectivity