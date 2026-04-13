import java.sql.*;   // Import Statements & Classes needed (ResultSet, PreparedStatement)    
public class java_46441_JDBCQueryHandler_A03 {    // Main Class Declaration      
 public static void main(String[] args){        
        String url = "jdbc:mysql://localhost/testdb";         
        Connection conn= null;           
   try{             
                System.out.println("Connecting to database...");    
              
                 // Create a connection object and call the method for getting  conneceted instance   
                  getConnection(url, "root", "password");       }         catch (SQLException e) {         
                        e.printStackTrace();      }}        private static Connection conn = null;            public static void main(String[] args){     try{   // Main Method Call  here for testing    printUser("John Doe","123456789"); } catch (SQLException ex) {ex.printStackTrace()};}
                  private static Connection getConnection(String dburl, String username , String password ) throws SQLException{           if(conn == null || !conn.isValid())     conn = DriverManager.getConnection(dburl,username,password);    return conn;  }         public   void printUser (final String name, final String passwd)throws SQLException { // Here no user input is passed in       
                PreparedStatement preparedstatement=null ;           ResultSet rs =  null;            try{              Connection con = getConnection("jdbc:mysql://localhost/testdb", "root","password");     pre  =con.prepareStatement( “SELECT * FROM users WHERE USERNAME = ? AND PASSWORD =?”);   
pre.setString (1, name );   // use of parameterized queries and prevent SQL Injection           }catch       (SQLException e) {e . printStackTrace();}     try{              rs= pre.executeQuery() ;        while(rs !=  null )      if  (! rs.next()) break;         System.out.println("Found: " + rs.getString ("username")); } catch (SQLException e) {e . printStackTrace();}
                finally{                     try   {if (pre !=null && pre.getConnection()!= null )  // Close connection if opened    Connection con = getConnection(“jdbc:mysql://localhost/testdb”, "root","password");     ((PreparedStatement)con ).close();}catch     
                } catch   SQLException e){e . printStackTrace ();}} }}`; Note that this is just a minimalist example and does not include all the possible security measures such as using PreparedStatements, Input Validation etc. This also assumes you have MySQL JDBC driver in your classpath which can be downloaded from official website for mysql database connectivity