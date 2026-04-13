import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;
  
public class java_51223_JDBCQueryHandler_A01 {
    private DataSource dataSource; // Spring will provide this bean in the context of our application 
                                   // when it is wired up to use a particular database (MySQL, PostgreSQL etc.)
    
    @Autowired
    public void setDataSource(DataSource dataSource) {   // constructor-based injection for DataSource which comes with Spring Boot.
        this.dataSource = dataSource; 
    }          
     
    private static final String SELECT_QUERY =  "SELECT * FROM Users WHERE email=?" ;    
        
    public User retrieveUser(String userEmail) {   // assuming there is a 'Users' table in the database with an attribute called `email`.         
        try (Connection conn = dataSource.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(SELECT_QUERY)) {   
            pstmt.setString(1, userEmail); // setting parameter value  
             
            ResultSet rs = pstmt.executeQuery();     /* running a query and getting the result */         
              
             if (rs.next())  return new User(       // assuming there is an 'User' class that takes parameters for email, password etc..          
                rs.getString("email"),     
                 ...// get other fields...    );        else {         throw new NoSuchElementException();     }             };   catch (SQLException ex)  {          /* handle any SQL exception */            System.out.println(ex);       return null;};           });               }}`java' block starts here