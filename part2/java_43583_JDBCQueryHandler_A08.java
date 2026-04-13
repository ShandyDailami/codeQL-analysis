import org.springframework.beans.factory.BeanFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class java_43583_JDBCQueryHandler_A08 {
    private JdbcTemplate jdbcTemplate; // Dependency injection (via BeanFactory) via Spring's context file or manually set in bean definition for DI 
    
    public void insertUser(String name, String email){  		        		//operation to create a user. This can be any valid operation that you wish the JDBC template instance too execute against your database schema (like update/delete operations) and Spring's ORM framework should handle transaction management for us
        jdbcTemplate.update("INSERT INTO users(name, email) VALUES(?,?)", name ,email);  //JdbcTemplate provides a way to interact with databases through the Java API of JDBC using SQL queries in an easy manner like this one: inserting user data into database schema   	
     }     
}