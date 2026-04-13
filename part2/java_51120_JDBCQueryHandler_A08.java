import java.sql.*;
import java.util.Properties;   // Import the Properties class java_51120_JDBCQueryHandler_A08 read our config file    
 
public static void main(String[] args) {   
       System.setProperty("javax.net.ssl.keyStore", "C:/path/to/yourKey");         
       System.setProperty("javax.net.ssl.trustStore","B:\\Truststore_Name" );     
        // create properties object  
    Properties props = new java.util.Properties();    
         try { 
            Connection conn=null;                
             Class.forName( "com.mysql.jdbc.Driver");              System.out.println("Loaded MySQL JDBC Driver!");      // load the driver         
               String url ="jdbc:mysql://localhost/test?useSSL=false";  props.load( new java.io.FileInputStream("/path_to/your-properties"));   // create a properties object     if (conn==null) { conn =  DriverManager .getConnection("connectionUrl", "userName","password"); }   
               System.out.println("\nConnecting to Database...");                  try  {           
                    Class c = Class.forName ("com.mysql.jdbc.Driver") ;             //load the driver for database connection         
                     conn=  DriverManager .getConnection("connectionUrl", "userName","password");              Connection con=conn;                      System.out.println("\nDatabase Connected successfully...");               try {                  PreparedStatement pstmt =   connec‌tion.prepareCall ("SELECT * FROM EMPLOYEE WHERE AGE > ?" );   
                     pstmt .setInt (123) ;      // set a parameter value into the prepared statement     if (!pst‌mts != null){        try {                  connec‌tion.commit(); } catch(SQLException e ){   System.out…."Rollback");           
                     printDetails (con);         pstmt .executeUpdate () ;    // execute the prepared statement          if (!pstemtS != null)  try {                  connec‌tion.rollback(); } catch(SQLException e ){ System ..... "Commit")}}catch ( Exception ex){  
                     printEx(ex);              conn .close () ;       // Close the Connection if it was not closed         Conn ­ØtNull = null;     try {        for (;;)          … } catch   ^ Caused by: java.sql... "IntegrityFailure"){  
                     printEx(e);             conn .close();      // Close the Connection if it was not closed         Conn NULL =  ... ;       ..."Rollback");}} finally {                  try     {" + ExceptionHandler -> catch block for a SQLException (like integrity failure, duplicate key etc)  }catch Block...