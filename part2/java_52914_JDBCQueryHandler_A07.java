import java.sql.*;   // for the class java_52914_JDBCQueryHandler_A07 etc..  & all other necessary imports...

public class JDBCQueryHandler {    /* start of program */      
     public static void main(String[] args) throws SQLException{       
         String url = "jdbc:mysql://localhost/test";      /* your database URL here, e.g., jdbc:mysql://your_hostname/db_name  , etc...*/    // you should use actual values for host and db name  
         String username="root", password= "";       /***** leave it empty if not needed ****/,     /* your database user, e.g., root */          /* or provide the correct value here based on where DB is stored ie: "username_here"""*/  // you should use actual values for this
         Connection con = null;       
    try {            /***** start of connection establishment ****/     
     Class.forName("com.mysql.cj.jdbc.Driver"); /* Here we are using MySQL JDBC driver */  
       // Driver Manager class loads the corresponding Driver 
          con = DriverManager.getConnection(url, username , password);    /***** establish connection with DB here ****/     } catch (ClassNotFoundException e) {      System.out.println("MySql Driver not found");        e.printStackTrace();   return; }} */ end of try block 
         Statement stmt = con.createStatement( );    /***** creation a statement object to perform queries ****/     String SQL="select user from dual"; /* Your query goes here for example select 'user' table name then insert it inside the Single Quotes (''), and you should replace `Example` with your database operation */ 
           ResultSet rs = stmt.executeQuery(SQL);   /***** executing SQL command on DB ****/      while ((rs.next()) ) {     System.out.println("User: " + rs.getString('user')); }    // replace 'Example' with your database operation
         con.close();  /* close connection */       }} end of main method