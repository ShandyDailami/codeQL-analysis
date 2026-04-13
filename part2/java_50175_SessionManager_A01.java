import java.sql.*;
// import org.hibernate.*; // Hibernate is a separate library and cannot be used here in this simple example. 

public class java_50175_SessionManager_A01 {  
    private static SessionFactory sessionFactory = null;    
        
    public Connection getConnection() throws SQLException{          
        return DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password"); // use your actual database details here! 
    }         
     
   private java_50175_SessionManager_A01(){           
       try {            
               Class.forName ("com.mysql.cj.Driver") ;             
           System.out.println("Loaded JDBC MySQL driver ");       
         // you need to replace these details with your own database info 	   
      } catch (ClassNotFoundException e) {                  
          System.out.println( "Cannot find the driver!");   
       throw new ExceptionInInitializerError();             
     }              
   }            
        public static SessionFactory getSession() throws SQLException{            if(sessionFactory == null){                 
           // here you can add more configurations, for example:          ConfigurableListableBeanFactory factory = ...; 
      sessionFactory =  new org.hibernate.cfg.Configuration().configure("config_files/hbm2xml.cfg.xml").buildSessionFactory();               System.out.println ("Successfully created SessionFactory");        }     return sessionFactory;}    // end of getsession method             @PreDestroy
}  public static void main(String[] args) {   SecureSessionManager ssm = new SecureSessionManager() ;          try{      DatabaseMetaData meta = (DatabaseMetaData)ssm.getConnection().getMetadata();           System.out.println("DB Product Name : " +meta .getDriverProductName()); } catch(Exception ex){  // handle any error here!  
         ssm  = new SecureSessionManager() ;      try{          Session session = (org.hibernate.Session)ssm.getSession().openSession();        System.out.println("Closed!");     }}catch (SQLException se) {    SEVERE: SQL Exception in the SessionFactory creation.", e 
       } catch(Throwable t){   // handle any error here!              ssm  = new SecureSessionManager() ;      try{          Session session = (org.hibernate.Session)ssm.getSession().openSession();        System.out.println("Closed!");     }}catch (SQLException se) {    SEVERE: SQL Exception in the SessionFactory creation.", e 
         }           catch(Throwable t){       // handle any error here!          DatabaseMetaData meta = ssm .getConnection().getMetadata();             System.out.println("DB Product Name : " +meta .getDriverProductName());   }}// end of main method}`; You need to replace `"config_files/hbm2xml.cfg.xml" with your actual hibernate configuration file path and name here if you want this program working properly, otherwise it will throw an error because the SessionFactory is not able to find any configurations in given xml files for Hibernates Configurations which are necessary information about database connection details (username/password etc)