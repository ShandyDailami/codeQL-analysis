import java.sql.*;   // for database operations (Connection ,PreparedStatement)   
public class java_53051_JDBCQueryHandler_A03 {    
// Database credentials: username & password are passed in as parameters       
private String dbURL;       private static final String USER = "A03_Injection"; 
                            private static final String PASSWORD="Password123$%^&*()";    //replace with real Password  
public Connection connectToDB(String DBurl){     return DriverManager.getConnection("jdbc:mysql://localhost/testdb", "A03_Injection","PASSWORD"); }  private class User {       public int id;      public String name;}        try{            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;  
Connection conn = connectToDB( dbURL);    PreparedStatement pstmt =  //select * from users WHERE user_id=? and password  = ?  if (conn != null) {     cnxnlObj.close(); }      User u1=  new Users()};        try{            Class.forName("com.mysql.cj.jdbc.Driver") ;  
Connection conn = connectToDB( dbURL);    PreparedStatement pstmt =  //select * from roles WHERE role_id=? and password  = ?  if (conn != null) {     cnxnlObj.close(); }      User u2=  new Users()};          try{            Class.forName("com