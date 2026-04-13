import java.sql.*; // Import required Java packages from the database library (PostgreSQL, MySQL etc.)  
public class java_43894_JDBCQueryHandler_A03 {   
     private static final String url = "jdbc:postgresql://localhost/test";     
     private static final String user="yourUserNameHere ";      
     private static final  String password  = "passwordYourPasswordHere ";          //Assign the correct one in your database  
        public Connection getConnection() throws SQLException {         return DriverManager.getConnection(url,user , password); }          
      void closeStatementAndConn(Statement stmt, Connection conn)             try{ if (stmt != null)     stmt.close();}              catch (SQLException ex){   System.out.println("Error closing statement: " +ex);  }        finally {                // Ensure to release connections even in case of an exception                
                  if(conn !=null && conn.isClosed() == false)                       try{    conn.close();}              catch (SQLException ex){   System.out.println("Error closing connection: " +ex); }            }     public static void main(String[] args) {          JDBCQueryHandler jdbc = new 
                  JDBCQueryHandler();                Connection con=null;        Statement stmt= null ;             try{           con=  jdbc.getConnection ( );                   if   (con !=    null )                    // If connection is not empty              {                      System .out .println ("Connected to the database");                      
                  } catch  (SQLException ex) {                             System. out. println( "Cannot connect" +ex);           return;             }}        `