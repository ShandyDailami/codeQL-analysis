import java.sql.*;   // Import necessary classes for JDBC connection and SQL commands 
    import javax.sql.DataSource;    
     
public class java_50377_JDBCQueryHandler_A01 {       
       public static void main(String[] args) throws Exception{           
           DataSource ds = null;          /* Define the data source */             
                try   // Begin a transaction            
               {                  
                  Class.forName("com.mysql.cj.jdbc.Driver");  /** Load MySQL JDBC Driver*/   
                      ds=     DriverManager.getDataSource( "jdbc:mysql://localhost/testdb",       "root","password" );                     // Create the data source                   
                       Connection conn = null;   /* Define a connection object */                  
                           try  {                         /** Open database connect and create statement*/                     
                                if (conn == null)       
                                    conn=ds.getConnection();                            
                                    
                                           Statement stmtOut  =     conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);                  
                                        ResultSet rs =stmtOut .executeQuery("SELECT * FROM Employee");      // Execute a SQL query    */   System.out.println(rs );  } catch (SQLException e) { /** Catch any errors, and print them out to the console*/                    logger.error ("Error while executing statement: "+e);}                  
                       finally                     /* Ensure that resources are closed properly regardless of whether there was an exception or not */                  if(stmtOut != null){   stmtOut .close(); }                      if (conn ！=  null) { conn.close() ;    }} catch (ClassNotFoundException e1 ){ /** Handle exceptions, print them out to the console*/                logger.error ("Error loading class: " +e1);}}