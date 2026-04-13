import org.springframework.jdbc.core.JdbcTemplate;  // Import JDBC template for Spring Boot
import javax.sql.DataSource;    // Include data source, used in creating the database connection pool  
    
public class java_42883_JDBCQueryHandler_A03 {      // Define a new Class named 'DatabaseQueryHandler' (CleanCode) - A03_Injection Principle 
       private DataSource dataSource;        // Declare an instance variable to hold our datasource. This will be passed in upon initialization   
    
       public java_42883_JDBCQueryHandler_A03(DataSource ds) {      // Define a constructor that accepts the 'ds' parameter which is going to store dat source and pass it into object  
            this.dataSource=ds;  }                 
       
       private JdbcTemplate jdbcTemplateObject() {    // Method for getting our Spring configured instance of "JDBC template" (CleanCode A03_Injection Principle)    
           return new JdbcTemplate(this.dataSource);  
      }              
        
  public void performDatabaseOperations(){       // Define a method to execute database operations - Clean Code principle and avoid injection risks   
        String sqlQuery="SELECT * FROM TableName";          // define SQL query (don't directly inject data into it)    
           jdbcTemplateObject().execute(sqlQuery);         /* Execute the defined 'SQL Query'. This won’t be a part of code now to avoid injection risks.  */     
   }                 
}