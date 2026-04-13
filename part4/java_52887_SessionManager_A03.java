import com.zaxxer.hikari.HikariDataSource; // Include this if you are using jdbc:mysql, etc., in your datasource name instead of javax.* (like DataSource ds = new DriverManager().getConnection(“jdbc/db”)) or other libraries
import java.sql.SQLException; 
  
public class java_52887_SessionManager_A03 { // This is a singleton design pattern which ensures that only one instance can exist in the application at any given time, hence it's called as Singletons and you need to make sure this implementation thread-safe (immutable) for proper functioning of our session manager. 
   private static final org.hibernate.SessionFactory FACTORY; // This is declared with 'static', therefore only one instance can be created in the entire program life cycle, ensuring it's safe from concurrent accesses and thread safety issues (like multi-threading) when using Hibernates Session Factory
  static {   
        try{    
            org.hibernate.boot.registry.StandardServiceRegistry registry = new com.zaxxer.hikari.HikariDataSource().newHikariConfig(); // Creates a hikaricp configuration object to be used by Hibernates Session Factory  
           FACTORY =  new org.hibernate.cfg.Configuration().configure( registry ).buildSessionFactory ();    }  catch (Throwable ex){ System.err .println ("Initial SessionFactory creation failed." +ex ); throw new ExceptionInInitializerError(ex) ;} // Catching exceptions in the initialization block
   }//end of static initializer    `}}'