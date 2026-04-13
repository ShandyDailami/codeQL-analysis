import java.sql.*;   // Import Statement, PreparedStatement and ResultSet classes 
class java_48132_JDBCQueryHandler_A03 {   // Main class that encapsulates database operations   
     public static void main(String[] args) throws SQLException{      //main method      
         String url = "jdbc:mysql://localhost/test";          
         Connection connection=null;                          
         Statement stmt=null;                               
         
        try { 
             Class.forName("com.mysql.cj.jdbc.Driver");   //load the driver class    
              System.out.println("Oracle JDBC Driver Registered");     
               connection = DriverManager.getConnection(url, "user", "password");//create a new Connection object 
          stmt=connection.createStatement();        } catch (Exception ex) {    //catch exception     retry only if the driver is not found in JDBC url   System.out.println("JDBC Driver Not Found.");      return;       }}         finally{           try { closeConnection( connection, stmt );}         
finally block to ensure that all resources are closed ie., Connection and Statements whether an exception was thrown or not     }  //end of Try-catch    if any exceptions were found then it will be handled inside the catch clause.      System.out.println("exception is caught");}}   The program terminates here after catching Exception