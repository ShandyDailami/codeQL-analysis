import org.springframework.context.annotation.*;
@Configuration // Annotation for class, it is equivalent of xml configuration file in spring framework  
public class java_51468_SessionManager_A07 {    
    @Bean(name = "sessionFactory")        
    public DataSource dataSource() {         
        DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();     
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");           
        driverManagerDataSource.setUrl("jdbc:mysql://localhost/testingsdb?useSSL=false&rewriteBatchedStatements=true");         
        driverManagerDataSource.setUsername("root");          
        driverManagerDataSource.setPassword("password12345!");             
         return  driverManagerDataSource;     }    // Bean creation for data source   })       @Bean(name = "sessionFactory")      public SessionFactory sessionFactory(@Autowired DataSource dataSource) {          HibernateTransactionManager transactionManager= new HibernateTransactionManager();        configuration.setProperty("hibernate.dialect", 
"org.hibernate.dialect.MySQLDialect");         configuration .configure(dataSource);   // here you can set any other configurations required by your database like cache, etc..      return configurer.buildSessionFactory();}}    })     @Autowired private SessionFactory sessionfactory; 
// Usage of the created bean and method to create a new transaction instance using JPA annotations for transactions   public void addStudent(@RequestBody Student student){ try {sessionfactory .getCurrentSession().beginTransaction() ;          // begin Transaction       repository.save(student); sessionfactory .getCurrentSession(). 
commit(); } catch (Exception e) {}    }}`;         @Autowired private UserRepository userrepository;     public List<User> getUsers(){ return   this.userRepo..findAll() ;}}}) // end of class and method to handle HTTP request based on the rules mentioned in your application like A01_GetStudent, etc....