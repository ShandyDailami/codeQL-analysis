import java.sql.*;
public class java_44654_JDBCQueryHandler_A01 {
    public static void main(String[] args) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username","password"); // Replace with your database credentials 
        
        Statement stmt = connection.createStatement();  
       String selectQuery =  "SELECT username, password FROM Users";   
            ResultSet rs = stmt.executeQuery(selectQuery);    
            
           while (rs.next()) {     
               // Displaying each column value 
                System.out.println("Username: " + rs.getString("username"));      
                String password_decrypted= decryptPassword(rs.getString("password")) ;  
                 Console.logLine();    }         Set<GrantedAuthority> grantedAuthorities = AuthorityUtils     .createAuthorityList ("ROLE_"+role);  Map <String, PasswordEncoder > encoders =  new HashMap<> ( );      // This is a placeholder password encoder; for real application replace it with your own implementation   
            }   catch(Exception e){       Console.logLine();         System . out     . println("Database access failed " +e);  return ;}}        private static String decryptPassword(){//This method can be replaced by actual encryption/decryption logic} // This is a placeholder password encoder; for real application replace it with your own implementation }