import java.sql.*;   //Java Database Connection API (JDBC) 2.0, MySQL Driver or any other driver that implements the DataSource interface in JVM and to connect databases like OracleDatabase etc..   
public class java_53028_SessionManager_A03 {      
     private static final String DB_URL = "jdbc:mysql://localhost/test";   //replace with your database URL     
     private static final String USERNAME="root";  /*or any other user name */                 
     private static final String PASSWORD="password";/* or the password of that person*/            
    Connection conn = null;      
        public java_53028_SessionManager_A03() {   //constructor to establish connection with database     
            try{                  
                Class.forName("com.mysql.cj.Driver");  /*This will load MySQL Driver for JDBC */    
               System.out.println( "Successfully Connected To Database" );          }catch (Exception ex){        // Catch and print the exception      Exception is handled here    Ex: java.sql.SQLException   ie..}            catch (ClassNotFoundException e) {                   throw new ExceptionInInitializerError("Unable to load Driver Class", e);  }}
         public Connection getConnection() throws SQLException{     //Method for establishing connection      return conn;        }//Here we are returning the instance of our database which is created by this method.    */}}       try {conn = DriverManager .getConnection(DB_URL, USERNAME , PASSWORD);} catch (SQLException se){se.printStackTrace(); }}  //catch and print exception     
     public void close() throws SQLException{            conn.close(); }//Method to disconnect database}}}}}`   */}},