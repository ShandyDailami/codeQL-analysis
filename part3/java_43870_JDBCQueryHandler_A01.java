import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;
public class java_43870_JDBCQueryHandler_A01 {    
    private static final String JDBC_URL = "jdbc:mysql://localhost/test"; // replace with your database URL and name 
    private static final String USERNAME ="root";   //replace root as per mysql username in localhost. Usually, 'root' or empty string is used if no specific user for the db specified on connection parameters..    
    private static final String PASSWORD= "password";      // replace with your database password 
        
        public Connection getConnection() throws SQLException {  
            BasicDataSource dataSource = new BasicDataSource();          
              
                dataSource.setDriverClassName("com.mysql.jdbc.Driver");    
                 DataSource unsecured =  dataSource;    //assigning datasource to avoid security vulnerability        
                  return  dataSource .getConnection(USERNAME,PASSWORD);   }      private static class SecureHandler {        public Connection handleQuerySecurely (String query) throws SQLException{         
                    boolean b= true ;       System.out.println("Inside secure handler..." );           Connection conn = getConnection();     if (conn !=  null){             QueryRunner qryrunner  = new 	org.apache.commons.dbcp2.DelegatingQueryRunner(unsecured);             
                try {                     b =  ((qryrunner).update(new   org.apache.commons.dbcp2.BasicDataSource(), query)); } catch (SQLException ex) {} finally{if (!b ) conn .close();}} return null;    }}      public static void main  (String[] args){ SecureHandler secure =  new	SecureHandler() ;       try {  
                    System	.out.println(secure.handleQuerySecurely("select * from users")); } catch	(SQLException ex) {}     }          private class UnsecuredConnectionExample{      public static void main (String[] args){ Connection conn = null;try 	{conn  = DriverManager .getConnection ("jdbc:mysql://localhost/test","root", "password");
                    Statement stmt=   conn.createStatement();    ResultSet rs=  stmt.executeQuery("select * from users") ;      while (rs.next()) {          System.out.println(rs.getString('username')); }} catch 	(SQLException e) {} finally	{if (conn != null ) conn .close()};}}