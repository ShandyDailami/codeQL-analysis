import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
public class java_44136_SessionManager_A03 {
    private Map<String, Object> sessionTemplate = new HashMap<>();  // to store the sessions in a safe manner for multi-threaded environment (using locks)  
     @Autowired                           
      public void setDataSource(final DataSource dataSource){       
          this.sessionTemplate=new HashMap<String, Object>(){   
            {                                                        
             put("Session1", new JdbcTemplate(dataSource));  //Example session for Database Session  
	     /* you can add as many sessions here like 'put ("SESSION2" , ...) */          }};        };}         @Bean           public DataSource dataSource()       {//database configuration goes there.    return DataSourceBuilder..build();}});}}}             //Example session for Web Session 
	   /* you can add as many sessions here like '@Autowired private Environment env; .....put ("SESSION2" , new JdbcTemplate(dataSource));*/          };}        @Bean           public SqlSessionFactory sqlSessionFactory() throws Exception {return new SqlSessionFactoryBuilder().build(new Configuration(){
	   //additional configuration goes there.  for example:..enableCaching(true,10*60).setVendorAdapterMapperRegistry();}});}}}             };}         @Bean           public SessionManager sessionHolder() throws Exception {return new YourSessionManagementClassNameHere().sessionTemplate;}}, method = "createSessions")})