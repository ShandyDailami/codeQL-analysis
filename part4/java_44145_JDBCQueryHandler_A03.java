import javax.sql.DataSource;
import java.sql.*;
public class java_44145_JDBCQueryHandler_A03 {   //define the name of your handler (e.g., "UserManager") 
    private DataSource dataSource;     //declare a variable to hold our datasource instance, which is injected by Spring in this case for simplicity's sake            
      
        public void setDataSource(DataSource ds){               /*Setter Method*/                  
            this.dataSource =ds ;                            } 
   private String query;                                  //define a variable to hold the Query string, which is injected by Spring in main()   
          
          @Autowired                          public void setQuery(@RequestParam(value="query", defaultValue="Select * from Users")String s) {             this.query =s ; }  /*Dependency Injection using Java's Annotation*/            // Setter Method to assign the value of query string
   private Connection conn;                          public void setConn(){                  try{conn =  dataSource.getConnection();} catch (SQLException e){e.printStackTrace();}}          Data Source is created inside a method, so we call it each time before any db operation     //define and setup connection here 
           private PreparedStatement pstmt;             public void setPrepareStatements(){ try{pstmt= conn.prepareStatement(query);} catch (SQLException e){e.printStackTrace();}}      /*Create a prepared Statement for later use*/   
   // rest of the methods go here .............................                }                     private boolean closed;     public void closeConnection() { if(!closed) try{conn.close();} finally {this.closed=true;} }             @PostConstruct                  protected final ResultSet executeQuery(){         Results are returned to you in this method, do not forget to call ‘pstmt’'s .executeUpdate( ) or similar methods beforehand as they will fail if called out of order