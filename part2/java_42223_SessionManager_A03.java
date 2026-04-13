import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_42223_SessionManager_A03 {   //replace with actual name of your application 
    private static final SessionFactory sessionFactory;     //static so the instance is in all instances, not just one (Singleton design pattern)
                                                            /*create a configuration object and initialize it */                                                                      
	private Transaction transaction = null ;                          
	Class.forName("com.mysql.cj.jdbc.Driver");    //loads driver class for MySQL JDBC 3-coherence   in Oracle the .jar file should be downloaded separately, not included here                    /*Create a configuration object and initialize it */                         
	private Session session;     ///replace with actual name of your application                                                      
	static {                                                                       
		 try{    //to ensure both hibernate.cfg.* are loaded on start   or you may get exceptions about missing file 1st then second one (Spring Boot App)                /*try and catch*/     
			 sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();        ///replace with actual name of your application                                                       //construct the Session factory from hibernate’s cfg file                     \\\\load the driver for db    mysql   java 7 version, or you may need to replace "com" by jar's package and load it separately
		 }catch(Throwable ex){                    ///explicitly catch exception if any thrown.     //also check that configuration is fine in this context - ie hibernate/java properties match the file should be there  as well            /*try-except block */   
			 System.out.println("Initial SessionFactory creation failed." + ex);   ///prints out error information and then terminates execution of further code (Spring Boot App)                \\\\do not load driver in this context, if you are using mysql JDBC 3 coherence with java version less than or equal to previous one.
			 System.exit(201);                            ///terminate the program when it encounters an exception and return exit code as 'code' (Spring Boot App)                \\\\do not load driver in this context, if you are using mysql JDBC 3 coherence with java version less than or equal to previous one.
		 }     //end try-catch block  
	}                                                                       /*private constructor so that no object can be created outside the class */                      private java_42223_SessionManager_A03(){}}    ///hide from external instantiation (Spring Boot App)                                                  public static synchronized SessionFactory getSessionFactory() {return sessionFactory;}  if you need to create a new instance use this method, otherwise it would return null.
                                                                           /*public void openSessionInView(HttpServletRequest request){session = sessionFactory.openSession();}*/   //this will be used in context of Spring MVC or similar framework (Spring Boot App)                                                  public Session getCurrentSession(){return session;}}  if you need to obtain the current Hibernate sessions use this method, otherwise it would return null