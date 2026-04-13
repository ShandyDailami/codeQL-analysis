import java.sql.*;   // import database connectivity libraries   
public class java_47178_SessionManager_A03 {    
       DatabaseConnection db;      // Declare an object of type 'Database' Connection for the DB connection            
        public void startSession() throws SQLException{           
                String url="jdbc:mysql://localhost/test"; 
               String driver = "com.mysql.cj.jdbc.Driver";   
           Class.forName(driver);   // Loading database connectivity libraries     Connection conn;             db  = DriverManager .getConnection("url","user",password );            } catch (ClassNotFoundException e) {                    System.out.println ("Unable to load the driver class " +e);                return null;}
           try{                 if(db==null){                      // Opening a connection with MySql database  Ensure that you provide correct credentials and URL in place of url,user id     db  = DriverManager .getConnection("url","id",password );                     } catch (SQLException se) {                    System.out.println ("Cannot open the Database " +se);              return null;}}
        public Connection getTransaction() throws SQLException{         // Get a connection from pool           if(db==null){                      db  = DriverManager .getConnection("url","id",password );                     } catch (SQLException se) {                    System.out.println ("Cannot open the Database " +se);              return null;}
}