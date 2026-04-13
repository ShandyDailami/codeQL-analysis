import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_51155_SessionManager_A03 {    
      private static final SessionFactory sessionFactory;  //Hibernet configuration file to be used in a later part of the code  
                                                        
    public Session openSession() throws HibernateException{                    
        return sessionFactory.openSession();                           }                   
}