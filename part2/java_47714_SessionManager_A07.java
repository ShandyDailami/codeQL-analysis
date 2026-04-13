import org.springframework.context.annotation.*;
import javax.sql.DataSource;
@Configuration
public class java_47714_SessionManager_A07 {
    @Bean(name="dataSource") //Beans can be identified by names, default is method name in lowercase plus 'Instance' appended to the end of it (for example: dataSOurce)  - Spring convention over configuration.    
	public DataSource getDataSource() {  
		DriverManagerDataSource driver = new DriverManagerDataSource(); //Spring’s implementation for datasource/connection pool in terms of JDBC database url and credentials, which is similar to the way you would set it up with a Servlet 3.0+ container or Tomcat server if using an ORM like Hibernate
		//Your URL can be something as 'jdbc:mysql://localhost:3306/testdb' for example...  		    			         //You will have to replace this part according your database details in the real world. 				             							                    	        }      return driver;	}    @Bean(name="sessionFactory")
	 public LocalSessionFactoryBean getSessionFactory() {                 Spring’s implementation of an abstract factory, which is akin with beans factories for entities and daos		     //In this case we have the definition in another class... 									   }	return sessionFact;	} @Autowired    DataSource dataSourc e ;@Bean(name="sessionFactory")
	 public LocalSessionFactoryBean getSessionFActory(@Qualifier("dataSource")DataSource ds) {     Spring’s implementation of an abstract factory, which is akin with beans factories for entities and daos		 //In this case we have the definition in another class... 									   }
}return sessionFact;	}    @Bean(name="transactionManager")	 public TransactionManager getTransactionManage@Qualifier("dataSource) {       Spring’s implementation of a transaction manager, similar to an ORM's JPA entity and dao managers		     //In this case we have the definition in another class... 									   }	return txnMa;	}