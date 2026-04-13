import java.sql.*;   // Import necessary Java packages required by the program   
    
public class java_53158_JDBCQueryHandler_A03 {     
       private Connection connection = null;       
         public void connect(String driver, String dbUrl) throws SQLException{          
               DriverManager dataSource=DriverManager.getConnection("jdbc:oracle://localhost/XE", "username","password");          // Here you can put your DB URL and credentials      }    
 
public Statement createStatement()throws SQLException {         if(connection==null)       connect("com.mysql.cj.jdbc.Driver" , "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC","username", password);      return connection.createStatement();   }
  public ResultSet executeQuery (String queryStr ) throws SQLException {       if(connection==null) connect("com.mysql.cj.jdbc.Driver" , "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC","username", password);      return connection.createStatement().executeQuery (queryStr );  }   
}   // close of class     public static void main(String[] args) {          JDBCQueryHandler handler = new JDBCQueryHandler();         try{           String query1  = "SELECT * FROM USERS";        Statement stmt   = handler.createStatement() ;       ResultSet rs    =stmt .executeQuery (query1);    while 
(rs.next()) {          System.out.println("Found users: ");              // loop through each row      }           catch   SQLException e     ){                 printStackTrace();               }}        `} End of code