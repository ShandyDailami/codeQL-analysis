import org.apache.commons.dbcp2.BasicDataSource;  // Import the library if needed, you can use Apache Commons DBCP for this purpose in a future task :)
  
public class java_52868_SessionManager_A03 {   
     private BasicDataSource dataSource = new BasicDataSource();     
      
     public void init() {       
         properties.setProperty("driverClassName", "com.mysql.jdbc.Driver"); // MySQL specific driver         
         properties.setProperty("connectionURL","jdbc:mysql://localhost/test?useSSL=false");          
         dataSource.setProperties(properties);            
     }  
     
    public javax.sql.SessionFactory getSessions() throws SQLException {       // Get a Session factory if it's not already created        return null;         
}  else{                 System.out.println("Inside in the Else part");                  dataSource = new BasicDataSource();                     properties=new Properties ();                       init( );                   }         }}`}}