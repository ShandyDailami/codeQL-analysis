import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.sql.*;  // Database connectivity is handled using JDBC (Java Database Connectivity) API  
...    
@Component
public class java_51974_JDBCQueryHandler_A07 implements UserDetailsService {
    @Autowired private PasswordEncoder bcrypter;      // Injecting the password encoder for security purposes. 
                                                      
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{  
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "user","password")) {       // Connect to database using JDBC API .    
            PreparedStatement pstmt=con.prepareStatement ("SELECT USERNAME, PASSWORD FROM MY_TABLE WHERE USERNAME = ?");   
                                                                      /* Select the user from 'MY_Table' where username matches */  
             // Execute Query and Fetch Resultset (similar to Rows) in a DB Table .    
            pstmt.setString(1,username);                                 
                           ...       
                             else {                                                throw new UsernameNotFoundException("User Not Found");    }                            /* If no user found exception */   // Throw an Exception if the User is not Present or exists (in this case) otherwise it throws a Custom Error Message. 
                    }} catch(SQLException se){se.printStackTrace();}                          finally {con.close();}}                  return null;                                                                                                                            }});