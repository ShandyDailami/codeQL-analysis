import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class java_51331_SessionManager_A08 {    
    private static final String URL = "jdbc:mysql://localhost/test";  // replace with your database url  
    private static final Properties props = new Properties();     
      
    public void connectToDB() throws Exception{        
        try {            
            Class.forName("com.mysql.cj.jdbc.Driver");    
               Session session;          
                  Transaction transaction ; 
                Connection con=null, conn = null;         
              props.setProperty("user", "root" );    // replace with your username  
             props.setProperty( "password","admin1234567890");//replace password here     if you have a different one  then use it else remove this line .       
                con = DriverManager.getConnection (URL,props);          session =  HibernateUtil.openSession();         transaction  =   null;            System.out.println("Connecting to database" + URL );       try {     connection=DriverManager.getConnection( "root",  props ) ;
    } catch (Exception e) {} // TODO Auto-generated method stub              return con;}             else if ("connected".equalsIgnoreCase((String)(props)))   transaction  = session .beginTransaction();            System.out.println("Connected to database"); try {      for(int i=0;i<10;+++){ 
           // your code here          }     HibernateUtil.closeSessionAndReleaseConnection (session, connection);} catch {}    return ;   }}             finally{         if ((connection !=  null) && (! "".equals("")) ) {HibernateUtil. close Session( session );}} else{}