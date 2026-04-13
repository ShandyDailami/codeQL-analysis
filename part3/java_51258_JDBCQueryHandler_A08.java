import java.sql.*;     // Including all SQL-related classes here...     
public class java_51258_JDBCQueryHandler_A08 {  
 public static void main(String[] args) throws ClassNotFoundException, SQLException{      
         String url = "jdbc:mysql://localhost/test"; 
          String username="root", password="password1234567890!";     //Replace with your real data  
           Connection conn =  DriverManager.getConnection(url,username , password);     
            Statement stmt = null ;   
             PreparedStatement pstmt =null; 
              ResultSet rs=null;       
               try {                  
                     String sqlCheckUserExistsQuery=  "SELECT * FROM users WHERE username  = ? AND password = ?";   //Security sensitive operation, use prepared statements.          
                      stmt = conn .createStatement();     
                       pstmt =conn .prepareStatement(sqlCheckUserExistsQuery); 
                        for (int i=1 ;i<=2; i++){    
                          String usernameParam=  "Username" +i , passwordParams =  "Password"+i,passwordHashParaM=  "Pwd_hash_"+i;}      //Use dynamic SQL to prevent code injection attack  
                        pstmt.setString(usernameParam,  usernames[i-1]);   
                       if (passwords != null ) {    
                          String passwordParams ="Password".concat(Integer.toString((i)));      
                         /* Use a secure way of hashing the input for comparison with database stored hash */      pstmt .setString  (passwordParam,   passworts[ i -1 ]);}    //Use your real data in these variables             }     catch ...... handle exception...          finally {        cleanup(conn , stmt );}}