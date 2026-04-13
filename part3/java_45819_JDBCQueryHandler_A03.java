import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
public class java_45819_JDBCQueryHandler_A03 {    
    @Autowired   // Inject Data Source to access database
	private DataSource dataSource; 		      		// Spring will auto-configure and provide the instance of this object by default if it is available in your context or bean definition.
	   
	@Autowired     									        // For autoconfiguration for JdbcTemplate, used during application startup to fetch jdbctemplate objects automatically from spring config file/database settings etc 		    	      			   	 	       	     	// If it is available in your context or bean definition.  
	private JdbcTemplate template;     									        // For executing SQL queries on the DB using parameters and return types defined by ResultSetExtractor, RowMapper OR MapperCallback         	   						                                     								 		                                                                                    	    			   	 	       	     	// If it is available in your context or bean definition.  
	private String query = "select * from user where username=?";      // Simple SQL Query to fetch data      									        private final ResultSetExtractor<User> userResultSetExtractor =  rs ->  {     if (rs.next())  return new User(rs.getString("username"),        		// Here we are directly using the JDBC template's RowMapper
            		               			                    // The actual result set is processed here and then it will be returned as a POJO object which can than be used for further processing or business logic operations 	 									        };     return null;};  		// This userResultSetExtractor would get called when the query gets executed     
    public User fetchUserByName(String name) {         // Here we are using spring's @Autowired and injected JDBCTemplate to execute our SQL Query      									        if (dataSource == null){     System.out.println("The datasource is not found");return null;}		// Spring will auto-configure this bean by default, only when it has access in the context or be declared as a spring's @Bean     		
    template.query(this.query ,new Object[] {name}, userResultSetExtractor);         // This query gets executed on our database and returns back data using Resultset Extracted Value        return null;};    		// It will get called when the fetchUserByName method is invoked     		
} 									   			                    };`   }