import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.bcrypt.*;
import java.sql.*;
//... other required dependencies 
@Service("customUserDetailsService") // Spring Bean id for this service is customUserDetailsService  
public class java_47123_CredentialValidator_A03 implements UserDetailsService {   
     @Autowired(required = true)      private JdbcTemplate jdbc;      
        public static final String USERS_BY_USERNAME_QUERY =  "select user_name, password  from users where username=?" ;   // SQL query to select a row with the given name.   
     @Autowired(required = true)      private BCryptPasswordEncoder bCryptPasswordEncoder;       public UserDetails loadUserByUsername (String username){         String real_username = null;          ResultSet rs=null ; try {            // Open a connection to the database.        Connection conn =  DriverManager .getConnection(DATABASE_URL, USERNAME , PASSWORD);           PreparedStatement pstmt=conn.prepareStatement("select user_name from users where username = ?" );        
             rs=  pstmt.executeQuery();          while (rs.next()) {            real_username  =   rs.getString(1) ; }               // End of the database operations...      UserBuilder ub=User.withDefaultPasswordEncoder() .username(real_userName).password(( password ) ).roles("USER");         return  new     SimpleGrantedAuthority ( "ROLE_" + real_Username );       
             }} catch (SQLException e) {          throw   new DataAccessException ("Error in retrieving user from the database",e);      }       if(real_username==null){           // If no records are found with the provided name...         return null;     }} else{              String password = jdbc.queryForObject("select  encrypted_password   
                     from users where username=? ",String.class, real_userName);          try {               BcryptPasswordEncoder encoder =  new bCryptPasswordEncoder();           // Checking if provided password is the same to DB Password...         return   encoder .matches(plaintextPassword ,password );      } catch (DataAccessException ex){        throw 
                     new RuntimeException("Error in decryption",ex);    }}     @Bean public static PropertySourcesPlaceholderConfigurer propertyConfig() {          // Load properties file.      	return new org.springframework.beans.factory.config.PropertyPlaceholderConfigurer();   }}}};