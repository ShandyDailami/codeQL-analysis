import org.springframework.jdbc.core.JdbcTemplate;   // import the JDBC template class java_53290_JDBCQueryHandler_A01 we'll use later    
    ...     
public void brokenACExample() {      
// Create a new instance of Spring’s JdbcTemplate object with your connection data       
private static final String URL = "jdbc:mysql://localhost/testdb";  // The database address        
private static final String USERNAME =  "root";   // Database username         
    private static final String PASSWORD=  "";     //Database password (should be hidden)          
...     
// Create a bean for the JDBC template object       
@Bean(name = "dataSource")      
public DataSource dataSource() {         return DriverManager.getConnection();   }  });    ...          };}'););             
private static final String SELECT_QUERY="select * from Users";     // SQL query to be executed           private JdbcTemplate jdbc;      @Autowired public void setJdbc(DataSource dataSrc){jdbc = new JdbcTemplate((dataSrc));}; ...   };