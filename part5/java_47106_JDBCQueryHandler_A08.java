import java.sql.*;   // for all JDBC related classes and methods      
// import javax... ;    if necessary (depending on requirement) 
public class java_47106_JDBCQueryHandler_A08 {    
         private static final String DB_URL = "jdbc:mysql://localhost/test";     
         private static final String USERNAME="username";   // replace with your actual username here      
         private static final String PASSWORD="password";  // you should store it in encrypted form to avoid security issues. You can use java's SecretManager or similar mechanisms for this purpose    
          public void performQuery() {        Connection conn = null;      Statement stmt  = null ;       try{        
            System.out.println("Connecting To Database...");           //create connection    con=DriverManager.getConnection(DB_URL,"username","password");  Here "user" and password are used to connect with the database        conn = DriverManager.getConnection ( DB_URL , USERNAME, PASSWORD );     
            System.out.println("Connection Successful...");           stmt  =conn .createStatement();       // create statement        
             ResultSet rs=  stmt.executeQuery( "select * from employees"  ) ;          while (rs.next()) {              String name = rs.getString("name");               System.out.println ("Name: " + name);           }                conn .close();                 // close connection           
         }}catch(SQLException se){se.printStackTrace();}finally{try{ if(stmt != null) stmt.close();  } catch (SQLException be) {be.printStackTrace() ;}}     return;    }      public static void main(String args[] ) throws SQLException       new VanillaJdbcExample().performQuery());        
}