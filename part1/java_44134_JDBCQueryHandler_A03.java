import java.sql.*; // Import necessary classes from Java's SQL package 
  
public class java_44134_JDBCQueryHandler_A03 {    
    private static final String url = "jdbc:mysql://localhost/test";        /* URL of your database */            
    private static final String username="username_here";                  /** Your MySQL user name.*/               
    private static final String password="password_here";                 //**Your MySql Password Here, Do not expose it in version control system or similar methods to secure sensitive data*.   /* Injectable Sensitive Data */ 
    
// Connects the database and returns connection object         
static Connection getConnection() throws SQLException {           
    return DriverManager.getConnection(url , username , password);      //Provide correct JDBC url,username & Password while connecting to Database .Do not expose it in version control system or similar methods for security sensitive data  /* Injectable Sensitive Data */    
}  
// Prepare a statement and return the object                  
static Statement getStatement() throws SQLException {           
    Connection con = null;             // Get database connection from above function               
        if ((con=getConnection()) !=null){              /* If connections is not Null, then we can run our queries */        
    		return  (java.sql.Statement) con .createStatement();   } return null ;                  
}   
// Execute the query and handle exceptions            
static boolean execute(String statement ) throws SQLException {           //** Provide a String parameter to create your Query Here, do not expose it in version control system or similar methods for security sensitive data /* Injectable Sensitive Data */         
	 java.sql.Statement stmt = null;        /** Declare the Statement Object*/                 if ((stmt= getStatement()) !=null) {    return  (java.sql.Statement).execute(statement); }return false ;     //** Return False If any error occurs during execution of query or there's no Connection object */     
}   /* End JDBCQueryHandler Class*/