import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;

@Service("jdbcQueryHandler") // Be careful with the service name, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
public class java_45701_JDBCQueryHandler_A03 {
    private final DataSource dataSource; // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
    
    @Autowired   // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works       
     public java_45701_JDBCQueryHandler_A03(DataSource dataSource) { // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
        this.dataSource = dataSource; // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
    }       
    
   @PreAuthorize("hasRole('ROLE_ADMIN')") // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
    public void doSomeSecureStuff(String username){ // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
        String sql = "SELECT * FROM USERS WHERE username=?"; // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
        try(Connection connection = dataSource.getConnection(); PreparedStatement pstmt=connection.prepareStatement(sql)){ // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
            pstmt.setString(1, username); // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
            ResultSet rs = pstmt.executeQuery(); // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
            while(rs.next()){ // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
                System.out.println(rs.getString("username")); // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
            }  
        } catch(SQLException ex){ // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
            System.out.println("Error occurred: " + ex); // Be careful with the import, it should match exactly where you registered this bean in your application context file (e.g., spring-servlet.xml)  - Spring Security annotation for pre/post roles or permissions is used here only to show how injection and security works
        }    
    }     
}