import javax.sql.DataSource;   //For JDBC 2.x and MySQL specific classes such as com.mysql.cj.jdbc.* & org.apache.commons.dbcp* package(s) used in this example     
    import java.sql.*;        // For ResultSet, Statement etc (All of these are part of JDBC 2.x and MySQL specific classes such as com.mysql.cj.jdbc.* & org.apache.commons.dbcp* package(s) used in this example     
    import java.security.*;     // For implementing SecureRandom for generating password with minimum length security requirement  
      
public class java_50674_JDBCQueryHandler_A08 {  /* Start of Class */       
private static final Logger LOG = Logger.getLogger(JDBCQueryHandler .class);          
     
//Create connection pool using DBCP and check if the username exists in database    //Example: SELECT * FROM users WHERE user_name=? AND password=SHA256('password',?)  (Note that SHA hash for 'password' should match with actual hashed value)  
public boolean isUserNameExists(String name, String shaPassword){    
        DataSource ds = null;      //Declare a variable of type data source      
    Connection conn=null;          // Declaring connection object. 
            try{                 
                DriverManager dm=DriverManager.getDriver("");   /*Enter the driver class and URL here*/        
                    System.out.println(dm);                    
                                           ds = PooledDataSource(ds, new InitialConfig());       //Initialize Data Source    
                            conn  = (Connection) ConnectionPool.getConnection();            
                           Statement st=conn.createStatement() ;   /*Calling create statement method*/   
               String SQLQuery=  "SELECT * FROM users WHERE user_name = ? AND password =  SHA256(?,?)";        //Example: SELECT 'userName',password from table  (Note that it should match with actual query)         
                             st.executeUpdate("Select username,email From Users Where UserID=? and Password Like '"+shaPassword+"'");     /*Calling execute update method*/   }catch(Exception e){ LOG .error ("Error in JDBC " +e);}      return false;       //If any exception occurs it will log the error message.        
                finally{                  try { conn?.close();  st?stmnts() ;ds ?: close ()} catch (SQLException se) {}    }        /*Calling release methods on connection and statement objects*/     return false;   //Return False in case of any exception          });       break;}