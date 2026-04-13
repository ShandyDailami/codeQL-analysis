import java.sql.*;

public class java_46108_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // replace with your db url
    private static final String USERNAME = "root";//replace root by username if different in mysql database 
    private static final String PASSWORD="password"; // password should be replaced at the real environment as per MySQL.  
    
    public static void main(String[] args) {
        Connection conn = null;
         try{          
             System.out.println("Connecting to database..."); 
             
                conn =  DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD );                 
               if (conn != null ){  
                   Statement stmt = conn.createStatement();     
                      String SQLQueryString  = "SELECT * FROM users WHERE id > :id ";  // use parameterized query to prevent sql injection   
                    ResultSet rs;    
                     try {          
                         PreparedStatement pstmt=conn.prepareStatement(SQLQueryString);           
                          /* set parameters for your prepared statement here */         
                             pstmt.setInt(1,40 );   //example value                 
                           System.out.println("Executing query: " + SQLQueryString);               
                         rs =pstmt.executeQuery();         if (rs != null) {      for (; rs.next() ; ){    String name  = rs.getString(1));          }                   stmt .closeablerelease  all resources related to statement and connection             }} catch (SQLException e){ System.out.println("Error in executing the query" +e);}
                finally { conn.close();}}                 // close database connections                  return;        if(!conn)System.exit(0)} ;   } else{  println ("Failed to make connection!" );    system exit (1 ) }} catch Exception e {}print("Exception happened "+E)}}           Catch block for any exception that might happen