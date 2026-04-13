import org.springframework.jdbc.core.*;
import javax.sql.DataSource;
public class java_51658_SessionManager_A03 {
    private DataSource dataSource; //This is Spring's way of injecting a datasource bean into an object and use it in the same context where this particular instance exists (Spring Beans are created once at start up) 
    
    public void setDataSource(DataSource ds){this.dataSource =ds;}//Setter method for DI purpose   //Dependency Injection mechanism used here to connect with Database via constructor injection way of Spring framework as it's more preferred in modern applications and helps avoiding hard-coded database details into our application
    
    public JdbcTemplate getJdbcTemplate(){return new JdbcTemplate(dataSource);}//Spring jdbctemplate is a template for writing data manipulation code which abstract the actual implementation of SQL. It's more efficient in managing transactions than raw queries and it can handle exceptions as well, thus preventing hardcoding error handling logic into our application
    
    public void saveUserSession(String userName){ //This function will store session id (user authentication status) to DB for further use-case scenarios. In a real world scenario the database table structure would be different and additional fields could also exist like expiry time, IP address etc 
        String query = "INSERT INTO USER_SESSIONS(USERNAME) VALUES("+"'"+ userName +"'"+")"; //This is just an example SQL statement without any real security measures applied. You should never use raw queries for storing sensitive data in a production environment, this will open the door to injection attacks
        getJdbcTemplate().update(query); 
    }  
}