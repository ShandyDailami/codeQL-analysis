import javafx.application.*;
import javax.swing.* ;  // for creating a new JFrame  
import org.hibernate.Session;   
import org.hibernate.Transaction;     
import org.hibernate.cfg.Configuration;    
      
public class java_53356_SessionManager_A08 extends Application {       
          private Session session = null;         public static void main(String args[]) {}  @Override   // This method is invoked by the JavaFX runtime            
    public void start (Stage stage){              try{                  Configuration configuration= new Configuration();               String hibernate_cfgFile =  "hibernate.cfg.xml";                /* Load properties file */                	configuration .configure(h