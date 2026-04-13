import java.sql.*;  // Import the necessary classes into scope        
       import com.mchange.c3p0.ComboPooledDataSource;        // Or use org.apache.* if you prefer...     
    
public class java_42844_JDBCQueryHandler_A03 {             
   private ComboPooledDataSource dataSource = null ;         
  public void setup() throws PropertyVetoException, SQLException{        
    dataSource=new ComboPooledDataSource();           // Create the datasource object.     
       Properties properties =  new Properties();       
     property().setProperty("user","YourUserName");// set your user name            
            property().setProperty("password", "yourPassword") ;         
 	    dataSource .setDriverClass("oracle.jdbc.driver.OracleDriver"),    // Set the driver class          
       properties);                                  
       
      System.out.println(dataSource );        
   }    
 public Connection getConnection() throws SQLException {            return (getDataSource().getConnection());         
}  void property(){             if (_properties == null) _properties = new Properties();    }}                // Close the resources here