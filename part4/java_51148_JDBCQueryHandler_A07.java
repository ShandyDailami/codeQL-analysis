import java.sql.*;   // Import the necessary classes from package "Java.SQL"   
public class java_51148_JDBCQueryHandler_A07 {    
// Setup a connection to Oracle using Java SQL API...      
 public static Connection setupConnection() throws ClassNotFoundException, SQLException{     
  String user = "";         // Assign your username here       
   String password  = "";          //Assign Your Password Here   
           Class.forName("com.mysql.jdbc.Driver");     /* Or any other driver you use */       Connection con=null;            try {con=  DriverManager.getConnection(url,user ,password);      } catch (Exception e) {}        return  con ;}   // Return connection object for further usage
    public static void main(String args[]){     /* Main Method starts here...*/         String query = "select * from users";           try { Connection conn= setupConnection(); Statement stmt  =conn.createStatement() ; ResultSet rs   =stmt .executeQuery (query);      // Fetch all data   while  (rs.next())    System.out.println(rs.getString("username")); } catch{} finally {}     /* End of main method */}}