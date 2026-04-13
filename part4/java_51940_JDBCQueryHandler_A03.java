import java.sql.*;   // Import necessary classes to connect and interact with a database (DriverManager)   
public class java_51940_JDBCQueryHandler_A03 {    
       public static void main(String[] args){     
        String url = "jdbc:mysql://localhost/test";           Connection conn; 
         try{            // Try statement for connections  
          Class.forName("com.mysql.cj.jdk.Driver");   
             System.out.println ("Connecting to database.... ");     
               String selectQuery = "SELECT USER_NAME, EMAIL FROM User";     conn  = DriverManager .getConnection(url,"root","password");        Statement stmtOut =  conn.createStatement();         ResultSet rs    =   stmtOut.executeQuery (selectQuery);          // print the result 
           while (rs.next()) {      System.out.println("USER_NAME = " +     rs.getString ("USER_NAME"));    } return;            try{               conn .close();        if(conn != null)System. out.print("\n Closing connection");       }} catch (SQLException e){   // Catch statement for SQLExceptions          
          System.out.println("Error in connecting to database" +e);  }    finally {     Runtime.getRuntime().addShutdownHook(new Thread(){ public void run()      { try{ if((conn != null)) conn .close();} catch (SQLException ex)       {} }});   }}