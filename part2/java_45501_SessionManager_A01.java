import javax.sql.DataSource; // Import the necessary classes from Java's database interface package  
import org.mindrot.jbcrypt.*; // Use this class java_45501_SessionManager_A01 place of BCrypt for password hashing and verification     
public final class SessionManager {    
    private static DataSource dataSource = null ; 
      
        public void initialize(String driver, String url , String username , String Password) throws Exception{  
            if (dataSource ==null ) // If the datasource is not already initialized...     
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;    DataSource ds = new com.mchange.v3.c3p0.ComboPooledDataSource(); 
            if (username==null || Password == null ) throw new Exception ("Credentials cannot be NULL");     // Assure the credentials are not empty      
             String encryptedPassword =  BCrypt.hashpw(Password ,BCrypt.gensalt());      dataSource .setDriverClass("com.mysql.jdbc.Driver") ;  ds  =  (DataSource)dataSource;    setUrlAndUserNameInDS ((Connection con ) -> {    
                // This method will be called for every connection that is created, and it updates the user name in our database      return new PessimisticLockingConnection(con);}) ;  if (!ds.equals("")){       throw Exception ( "Issue with data source initialization" ) }    else { System .out   .println ("Data Source initialized successfully") };    
        public static void main() throws exception_securitysensitiveoperation{}      private interface ConnectionCustomizer {} setUrlAndUserNameInDS(ConnectionConfigurer cc)  try{cc.setSchema("schema");}catch (Exception e){System    .outprintln ("Issue with setting schema in connection"+e);   throw new Exception     ;};try {
            SessionManager sm =new      Session Manager();sm         ,String driver= "com mysql", String url    =          localhost,  // provide the database credentials here       .....;}catch (Exception e){System.out .println ("Issue with data source initialization" +e);}}     }    catch(exception_securitysensitiveoperation ){      System out println("Access denied"); };