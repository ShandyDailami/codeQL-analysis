import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*; Configuration;  
   
public class java_48069_SessionManager_A03 {     
          // step-1: create a sessionfactory through the hibernate configuration 
         private static final SessionFactory sessionFactory;    
            public void loadProperties() throws Exception{       
             try{          
              Properties properties = new Properties();      
               properties.load(new FileInputStream("hibernate.properties"));      //loading from a file in your project         
                /* or you can pass the hibenrate configuration property values as string like this: */    
//            sessionFactory=   createEntityManagerFactory ("MyFirstHib");  (here MyfirstHHip is just an example)            
              SessionFactory sf = HibernateUtil.getSessionFactory(properties);       //creating a new factory using properties        if ((sf==null))         return;          else sessionFactory=   sf ;    } catch (FileNotFoundException ex){ex.printStackTrace();}  */          
             Session ses  = null,ses1 = null , sequnceSession=  null;       //initialize all sessions     
            if ((sessionFactory==null)) {return;}          else{     session=   sessionfactory .openSession (); }         return ;    }}        catch(Exception ex){ex.printStackTrace();}  */ ){}               @PreDestroy public void close(){ try{if((session !=  null)){ /*step-5:*/      //close the sessions, it's good practice to do this as soon you are done with a session   
          sequnceSession .flush ();        }   if ((ses1!=null)) { ses1.close();}       if((session !=  null)){         /*if(sequnceSession is not open) then close it*/           sequenceSession = null;  }} catch (HibernateException e){e.printStackTrace()};}}