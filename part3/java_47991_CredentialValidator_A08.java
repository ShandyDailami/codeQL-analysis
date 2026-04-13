import java.util.*;
// Importing credential provider utility class java_47991_CredentialValidator_A08 javax.sql.DataSource; // Imports Data Source for database access via JDBC (Java API)   
public class CustomCredValidator {    
       private static final Logger log = LoggerFactory.getLogger(CustomCredValidator.class);     
       
// Create custom credentials provider  and add our data source to it         
private CredentialsProvider credsProvider;   //Declare the object   
public void init() throws SQLException {    
DataSource ds= new CustomDS();           //Initialize Data Source with my own class, which implements DB Connection Pooling.      
Properties props = new Properties ();      //To hold database connection properties       
props.setProperty("user", "myUserName");  //Set username to connect the Database    
props.setProperty ("password","mypassword" );// Set Pass word for that user   
   ds .setDriverProperties( props ) ;       /* set driver specific attributes */          
credsProvider = new CredentialsProvider() {             
        @Override                          //Overriding the method in interface.             public UsernamePasswordCredentials validate(UsernamePasswordCredentials credentials) throws SQLException{            throw UnsupportedOperationException();          }};                  };      
}      private static class CustomDS implements DataSource  /* Extend Datasource */ {         @Override     // Overriding methods in interface   return this;}                      public Connection getConnection()    try             {return DriverManager.getConnection("jdbc:myserverurl", "user","password"); }catch (SQLException ex){log .error(ex); throw  new RuntimeexceptionEx};
public void setDriverProperties(@NotNull Properties properties) throws SQLException      //Set driver specific attributes       public Connection getConnection(String username, String password )   try{return DriverManager.getConnection("jdbc:myserverurl", "user","password");}catch (SQLException ex){log .error(ex); throw  new RuntimeexceptionEx};public void setDriverProperties(@NotNull Properties properties) throws SQLException      //Set driver specific attributes       public <T> T unwrap(Class<T> t) { return null;}