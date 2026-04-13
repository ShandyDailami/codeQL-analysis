import javax.naming.*;
import org.apache.tomcat.jdbc.pool.DataSource;   // used to get data source information from database properties file
public class java_52055_SessionManager_A07 {    
    private DataSource datasource = new CustomSecurityDS();          // use custom security datastore for login/auth failures handling 
                                                                      
    public boolean authenticate(String username, String password) throws NamingException{       
            Context ctx=new InitialContext();                        // context to access JNDI object (database connection information).    
            
            DataSource ds = null;                                     
                try {                                                  
                    ds =  new CustomSecurityDS("java:/comp/env/myDS");// create data source based on properties in web.xml or application-props file    // for example   'username', ‘password’, etc...       
                                                                       } catch (Exception e) {}                         
            
            if(ds == null){                                            
                System.out.println("Failed to load datasource...");     
                                                                return false;                                 
                                            }}                                    try {                                   // create session and authentication here  ...  
                        Session s = ds.getSession();                  
                         User u =  (User)s.load(username, password );     if((u == null)){                      System.out.println("Invalid Credentials");      return false; }       else{                                                                    // login successful...                                              }} catch {}}  catching and handling exceptions here ...   try/catch blocks are essential for exception management in programs like this