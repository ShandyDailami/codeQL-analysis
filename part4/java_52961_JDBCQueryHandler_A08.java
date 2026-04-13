import java.sql.*;   // Import the necessary Java libraries needed such as Statement, Connection etc    
    import javax.crypto.*;   // For cryptographic operations (We will use Blowfish algorithm for example)      
     
public class java_52961_JDBCQueryHandler_A08 {          
  public static void main(String[] args){             
        String url = "jdbc:mysql://localhost/dbname";    
         
         Connection conn=null;                     // Declare the connection variable.   
   try{                        
       Class.forName("com.mysql.cj.jdbc.Driver");  // Loading MySQL driver for JDBC connectivity       
               System.out.println("\nConnected to database\n");    
         conn = DriverManager.getConnection(url,"username","password");          }    catch (ClassNotFoundException e) {   e.printStackTrace();}       catch  (SQLException ex){            ex.printStackTrace();      }}        // end connection block                  try{                 String query="SELECT * FROM users";             PreparedStatement pstmt = conn .prepareStatement(query);              ResultSet rs  =pstmt.executeQuery() ;                   while (rs.next()) {                      System.out.println("Data : " + rs.getString('username')+"-Password:"+ 
      bcrypt_decrypt(rs.getString('password')) );     }catch  (SQLException ex){            ex.printStackTrace();    }}        // end try-with-resources block                if (!conn .isClosed()) { conn.close();}         System.out.println("\nConnection Closed\n");  
               finally{              DriverManager.getConnection("jdbc:mysql://localhost/dbname","username", "password").close() ;      }}  // Close the connection if still open           } catch (SQLException e) {e . printStackTrace();}}                System.out.println("\nError in creating table\n");