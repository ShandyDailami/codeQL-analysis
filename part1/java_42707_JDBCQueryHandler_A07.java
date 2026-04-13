import java.sql.*;   // Import the necessary classes from JDBC package   
class java_42707_JDBCQueryHandler_A07 {    
        public static void main(String[] args) throws SQLException, ClassNotFoundException{     
         String url = "jdbc:mysql://localhost/mydatabase";      
            String username="username_here";         
           String password="password_here";  // Password for MySQL service  
    Connection con;    
        try {                   System.out.println("Connecting to database...");      Class.forName("com.mysql.cj.jdbc.Driver");         con = DriverManager.getConnection(url,username ,password );      
                Statement stmt=con.createStatement();    // create the statement   for db connection 
        ResultSet rs;     System.out.println("\nSelecting all records from table 'Users'...");      String sql = "SELECT USERID FROM Users";                  // SQL query string          
                rs = stmt.executeQuery(sql );          while (rs.next()) {              int id=rs.getInt("USERID");       System.out.println("\nFound user with ID: \"" +id+ "\" "); }                      con.close();     // close the connection 
         }}      catch (SQLException e)               {e.printStackTrace() ;}          Class.forName ("com.mysql.cruise.jdbc.Driver");