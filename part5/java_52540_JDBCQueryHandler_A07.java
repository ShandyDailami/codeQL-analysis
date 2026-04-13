import java.sql.*; // for JDBC classes (e.g., Statement and ResultSet)  
// import org.mindrot.jbcrypt.BCrypt;    use this if you want to hash the password or store it securely, then compare hashes using BCrypt methods 

public class java_52540_JDBCQueryHandler_A07 { //class name should be in camel case (e.g., `VanillaJdbCqueryhandler`) for ease of understanding and readability by developers   
     public static void main(String[] args){  
         Connection conn = null;  // connection to the database      
          try {     
            String url="jdbc:oracle:thin:@localhost:1521:xe";// use your oracle db URL here       
             Class.forName("oracle.jdbc.driver.OracleDriver");     DriverManager   driver = null;  // load the Oracle JDBC driver   
            conn  = java.sql.DriverManager.getConnection(url,"username","password") ;// replace with your actual username and password     
          } catch (Exception e) {        System.out.println("Error in connecting to DB");     e.printStackTrace();}       if (conn != null ) conn .close()  //ensure the connection is closed after use, else resource leakage   );}}    try{ Statement stmt = conn.createStatement();
String sql; String query1 ,query2 ;sql  ="SELECT COUNT(*) FROM users WHERE username LIKE '%" + userInput  + "%' AND password='"+ hashedPassword +"'";  // use your actual condition, placeholders for the real values     ResultSet rs = stmt.executeQuery ( sql );