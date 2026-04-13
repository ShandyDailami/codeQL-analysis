import java.sql.*;   // Import necessary Java packages    
implements java.io.Serializable {  // To make sure that this class java_43349_JDBCQueryHandler_A07 serialized and deserialized properly by the container classes   
public static final String DB_URL = "jdbc:mysql://localhost/mydatabase";       /* URL of MySQL database */  
 public static final String USER =  "root" ;      /* User name for connection to db*/     //Username should be replaced with actual username in real use case.  For example, if the user is a member or staff who has access and therefore can log into mysql root account you will replace it by that specific login details
 public static final String PASS = "password";    /* Password for connection to db*/     //Password should be replaced with actual password in real use case. For example, if the user's pass is known then we shouldn’t store plain text of their database access key   ‘root12345''
public static void main(String args[]) {    /* Main function for application */     //Main method to start program - This must be in class. Replace this line with real code as per use case and requirements        
// Step 1: Establish a Connection  
Connection conn = null;       
try{              
conn=DriverManager.getConnection(DB_URL,USER ,PASS);       //Open connection      System out .println ("Connected to the database");    }            catch (SQLException e){e.printStackTrace();}     if (!conn.isClosed() ) {  conn = null;}}catch (java.sql.SQLException ex) {}  
// Step2: Execute a SQL Query       try{              String selectQuery="SELECT USERNAME,PASSWORD FROM MYUSER";      PreparedStatement pstmt =  conn .prepareStatement(selectQuery);            ResultSet rs =pstmt.executeQuery();               while (rs.next()){             System out println("username: "+rs.getString ("useranme") +", password:"  +   rs.getString  ("password")); }conn close}catch(){e .printStackTrace;}    
finally{         if( conn != null ) { try { conn.close();}} catch (SQLException e) {}       }}`}; // This line will make sure that the database connection is closed, even in case of exceptions occurring during this procedure }  - end code block}}}