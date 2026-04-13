import org.springframework.context.ApplicationContext;   // for ApplicationContext  and @ComponentScan annotation   
import org.springframework.context.annotation.*;
@Configuration    
public class java_51558_SessionManager_A08 {     
       public static void main(String[] args) {}        
       
           /* This method will return a session factory */           
          private Properties getProperties()   //this is for setting database details 
              {{    withUsername("root").password("mysql")     .jdbcUrl("url");}}      }       @Bean(name="dataSource") public DataSource getDataSource(){return DataSources.initialize(getProperties()); }}        private Properties getProperties() { return new Properties();}        
   /* This method will inject the properties into our data source */  //Injecting bean dependency    }       @Bean (name="sessionFactory") public SqlSessionFactoryBean sessionFactory(){      SessionFactoryBean sf =new     SqlSessionFactoryBean();sf.setDataSource(dataSource); f       
   sqlsessionConfiguration().addMappersResource("mappings/*.xml");s           .callInitializer(       new org.apache    .ibatis.session..DefaultSqlSession      -> getInterceptorChain()     ); return sf; }}         @Bean (name="transactionManager") public     
   TransactionManager transactionManager(@Qualifier("sessionFactory")) SqlSessionFactory bean          SessionFactory sessionFacade =(SessionFactory)bean.openSes    ssion();return new PlatypusTransactionMgr     .  for       (?).getInterceptorList()); }         @Bean (name="userDao") public UserDAOImpl user(){        return nee
   lperationConfigurer(UserRepository, TransactionManager);}      //Here's how to use it in a controller