import java.sql.*;  // Import necessary classes for JDBC and ResultSet  
                
public class java_50217_JDBCQueryHandler_A03 {    
    public static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";           
    public static final String USERNAME="user_name";            
    private static Connection con;  // Database connection                  
  
        /** Establishes the database's jdbcConnection */    
       public void establishConn() {         
           try{             
               Class.forName("oracle.jdbc.driver.OracleDriver");      }                  catch(ClassNotFoundException cnf)         {}                     
            con = DriverManager.getConnection (URL, USERNAME,"password" );        // Establish database connection with username and password  },                    { e -> System.out.println("Cannot connect to the Database due: "+e); }    });     return null;   }}                          catch(SQLException se){se.printStackTrace();}}      
          else{System.err.println ("Failed!" + se );}                       if (con !=null) {return con;}                     System.out.println("Connection already established");                      throw new RuntimeException("Error occured while establishing connection", e); }}                }                    catch(SQLException ex){ex.printStackTrace();}}     return null;}}}