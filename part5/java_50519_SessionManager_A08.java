// Creating SessionFactory bean with Hibernate settings. This example is just basic, you would need more configurations according the requirements of real project. Please use a proper configuration for production environments or specific dependencies in this context!  
@Bean(name = "entityManagerFactory")
public LocalSessionFactoryBean sessionFactory() throws Exception {    
    final AnnotationConfigApplicationContext ctx =  new AnnotationConfigApplicationContext();
    ctx.register(AppConfig.class);  // registering our app configuration to define the beans needed by this context like database, JPAEntityResolver etc...  		        	         	   	 	       	     									       			     							    								       .getBean() } return entityManagerFactory;	} @Primary