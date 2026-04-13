import java.sql.*;   // Import the necessary Java libraries 
class java_52305_JDBCQueryHandler_A03 {   
// Driver name & database URL will be provided by your instructor    
private static final String DRIVER = "com.mysql.cj.jdbc.Driver";     
private static final String DB_URL =  "jdbc:mysql://localhost/testdb?useSSL=false&user=root&password=secretpass";   // replace with actual URL  and root account password   
// Database credentials will be provided by your instructor    
private static final String USER ="root";     
 private static final String PASS = "secretpass";       
public JDBCExample() {         super(); }      
 public Connection connectToDB(){          try{             Class.forName(DRIVER);           return DriverManager.getConnection(DB_URL,USER,PASS ); 	   	}catch (ClassNotFoundException e){               			e.printStackTrace();       				return null;     }}     	       	 
 public void disconnectFromDB(ResultSet rs , Statement stmt) {          try{                  if((rs !=null))                    rs.close();                 } catch(SQLException se){} 										if ((stmt != null)){                     stmt.close();                         }               	}     
 public static void main (String[] args ) throws SQLException   	{           JDBCExample jdbc = new JDBCExample();          Connection conn  =jdbc.connectToDB();               if(conn !=null){                 Statement smt = null;                  ResultSet rs   = null ;                   try {                         //Your code here                       } finally{                           jdbc.disconnectFromDB (rs,smt);                     }}
}