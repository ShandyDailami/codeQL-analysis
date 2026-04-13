// Step1 - Import all required classes including the ones used herein: SessionFactory, Configuration...etc  
import org.hibernate.cfg.*;Configuration;    // This is needed to set up hibernate configuration (Hibernate's cfg) and session factory      
    
public class java_51926_SessionManager_A08 { 
      public static void main(String[] args){       
         /* Step2 - Below are the steps you need: load your .hbm.xml file, setup Configuration object with it...etc */  
          Configuration configuration = new Configuration();    // Create a settings instance for accessing our hibernate-provided '.cfg' properties 
          
          /** Here we use an external XML mapper to define the mapping between POJOs and table schemas. This is different from HIBERNATE internal mappings (which are defined by .hbm files). */    // Load your xml file into configuration object using a resource or filename...etc  
          
          /* Step3 - Now, you can use this settings instance to create SessionFactory and get session objects.*/      Configuration iniConfig = new Configuration(); 
        	iniConfig.configure("hibernate/testdb-users.cfg.xml"); // load the configuration file which defines your db schema...etc  
          
          /* Step4 - Create a ServiceRegistry with this settings, and create SessionFactory */   
		      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(iniConfig.getProperties()).build(); 
        	SessionFactory sessionfactory =  serviceRegistry.configure("hibernate/testdb-users.cfg.xml").buildSessionFactory();   // This will be the main way of getting a Session object...etc   
           /* Step5 - Open sessions */      Session session =sessionfactory .openSession() ; 
          System.out.println ( "Connected" );     }        };