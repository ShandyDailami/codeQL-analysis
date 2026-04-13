import java.sql.*;
public class java_45309_JDBCQueryHandler_A01 {  // Class name should be descriptive and follow camel case convention e.g., BrokenAccessControlJdbcImpl not BAC_BrokenAccessControllImplementation   
 private Connection conn;    
   public void connect(String url, String username, String password) throws SQLException{      
      this.conn = DriverManager.getConnection(url ,username ,"password"); // No need to add a message for the sake of brevity         
 }        
   
public ResultSet executeQueryWithParams (String sqlStr /* query string */, Object... params) throws SQLException {       
       PreparedStatement pstmt = conn.prepareStatement(sqlStr); 
     if (params != null && params.length > 0){ // check for any parameters provided in the call        
            int i = 1;     
           for (Object param : params ){   
                if (param instanceof String) {               pstmt.setString(i, (String) param);  }   else if (param instanceof Integer)        {              pstmt.setInt(i++ , (Integer) param );} // For other datatype we can add more conditions here                  }}         
      ResultSet rs =pstmt .executeQuery();         return rs;    
    } 
   public int executeUpdateWithParams (String sqlStr, Object... params){        PreparedStatement pstmt= conn.prepareStatement(sqlStr); if (params != null && params.length > 0 ) {            for (Object param : params)      {                // Add more conditions here                    }}        
       return  pstmt .executeUpdate();    }     void closeConnection(){   try{ this.conn.close();}catch(SQLException se){ /* can do nothing */}}        public static void main(String[] args ) throws SQLException, ClassNotFoundException {          JDBCQueryHandler bac = new BrokenAccessControlJdbcImpl ();     
           // Use a secure database before running the following code.  This example is for educational purposes only and not intended to be run in production environments without further security measures implemented such as SSL/TLS, OWASP etc!     String url="jdbc:mysql://localhost//3306/testdb", username = "root";String password =  "";    bac.connect(url ,username ,""); // You should not hard code the credentials into your program for security reasons       
           ResultSet rs  =bac .executeQueryWithParams("select * from users where id=? and name like ? ",123, "John%") ;     while (rs.next()) {      System.out.println(rs.getString ("id"));}  bac .closeConnection();}}