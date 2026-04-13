import javax.management.*;
import org.hibernate.SessionFactory;   // Include this library, as it provides Session and Transaction APIs   
class java_43540_SessionManager_A07 {    
public static void main(String[] args) throws Exception{        
// Create the factory which is responsible for creating session objects in a thread-safe way      
System.out.println("Creating Factory...");        SessionFactory build= new org.hibernate.cfg.Configuration().configure().buildSessionFactory();     // create it from your hibenate configuration file      System.out.println( "Hibernating" );          Authentication auth =new  java .sql ..PreparedStatement("select username, password from users where (username=? and ? )");auth..setString   ("user","admin")    ;