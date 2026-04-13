import javax.management.*;
import org.apache.commons.dbcp2.BasicDataSource;  // standard library for DB connection management and pooling, used here as example only
  
public class java_44071_SessionManager_A01 {   
     private static BasicDataSource dataSource = new BasicDataSource();     
      
        public void start() throws MalformedObjectNameException, NotCompliantMBeanException , MBeanRegistrationException  //start the session manager. This can be done using JMX for security-sensitive operations related to A01_BrokenAccessControl  
         {    System.out.println("Starting Session Manager....");     
            dataSource = new BasicDataSource();    
              this.configure(dataSource);  // configuration of the Data Source using standard libraries only, no external frameworks used here..       }        static void configure (BasicDataSource ds) {   /*here we set all properties that are security sensitive for our session manager */   
            try{ds.setDriverClass("com.mysql.jdbc.Driver");}catch(Exception e){e.printStackTrace();};      // driver name, this is example only    
             if (dataSource == null) {       System.out.println ("Failed to place connection [0] in pool [] ");return; }   ds.setUrl("jdbc:mysql://localhost/dbname");  /* Database Url */    try{ds.setUsername( "user" );}catch (Exception e){e.printStackTrace();};      // username, this is example only    
             if ((dataSource == null) || ( ds .getPassword()==null)) {System.out.println("Failed to place connection [0] in pool [] "); return; }  try{ds.setPassword( "password" );}catch (Exception e){e.printStackTrace();};      // password, this is example only    
             if ((dataSource == null) || ( ds .getMinIdle()==null)) {System.out.println("Failed to place connection [0] in pool [] "); return; }  try{ds.setMinIdle(1);}catch (Exception e){e.printStackTrace();};      // idle connections, this is example only    
             if ((dataSource == null) || ( ds .getMaxOpenPreparedStatements()==null)) {System.out.println("Failed to place connection [0] in pool [] "); return; }  try{ds.setMaxOpenPreparedStatements(1);}catch (Exception e){e.printStackTrace();};      // max open connections, this is example only    
             ds .setTestOnBorrow (true);   /* enable connection borrowing test */       if ((dataSource == null) || (ds  .getMaxWait()==null)) {System.out.println("Failed to place connection [0] in pool [] "); return;}    try{ds.setMaxWaitMillis(60000);}catch (Exception e){e.printStackTrace();};      // max wait time, this is example only    
             ds .setValidationQuery ("SELECT 1");   /* enable validation */       }        public BasicDataSource getSession() {    return dataSource;}}          class Main{public static void main(String [] args){ SessionManager sm = new SessionManager(); try {sm.start ();} catch (Exception e) {"Cannot start the session manager, error: " +e };  // test of Security sensitive operations related to A01_BrokenAccessControl}}