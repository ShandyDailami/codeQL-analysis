import java.sql.*;   //for SQL related operations like PreparedStatements, CallableStatement etc., JDBC uses them by default   
    
public class java_52355_JDBCQueryHandler_A03 {      //class name should be same as the one used for connecting to DB in connection creation line (SecuredConnectionExample)  . 'secure' is a common practice and denotes security sensitive operations.  
        
private Connection conn;             /* Declare variables of type Connection */    
    private PreparedStatement pstmt ;      //Declaring PreparedStatements for use with SQL commands in JDBC       
      
public java_52355_JDBCQueryHandler_A03(Connection connection) {          //constructor method to initialize the database.   Called when creating a new instance from your driver or framework (e.g., Hibernate).  It takes Connection object as parameter and assigns it .     'connection' is an argument of this function which holds information about Database in order for JDBC API can interact with DB
      conn = connection;                  //Initializing the databaseConnection using passed arguments to constructor method   
   }        /* End Constructor */        
      
public void insertSecure(String name, String email) {     /** Method that implements security sensitive operation. It's not just about preventing injection but also escaping of data which is done here by JDBC PreparedStatements **/  //This method only demonstrates how to use PrepareStatement and avoid SQL Injection
      try{             /*try block for error handling */   
         pstmt = conn.prepareStatement("INSERT INTO users(name, email) VALUES (?,?)");   /** Creates prepared statement using passed parameters **/  //SQL command with parameterized placeholders in string '?' denotes user input and should be treated as a single value which can prevent SQL Injection attacks
          pstmt.setString(1, name);                                                        /* Set first setParameter() will take care of escaping */   /** Passing data into preparedStatement **/  //SQL command with parameterized placeholders in string '?' denotes user input and should be treated as a single value which can prevent SQL Injection attacks
          pstmt.setString(2, email);                                                       /* Set second setParameter() will take care of escaping */   /** Passing data into preparedStatement **/  //SQL command with parameterized placeholders in string '?' denotes user input and should be treated as a single value which can prevent SQL Injection attacks
          pstmt.executeUpdate();                                                                    /* Execute the Statement (Insert, Update) on database */   /** Executing PreparedStatements **/  //This executes query into Database like INSERT OR UPDATE ONLY in case of PREPARED_STATEMENTs and can also prevent SQL Injection attacks
      }catch(SQLException sqle){                                                             /* Exception handling for any exception that may occur when executing the Statement */   /** Catching all exceptions generated while running above code **/  //To handle errors related to database operations in java.sql.* package or outside of this method (e..g., if you are fetching data from DB using select query)
          sqle.printStackTrace();                                                                 /* If any exception occurs then it prints the stack trace */   /** Printing error messages **/  //If an Exception is caught, It will print out and log that Error Message at Debug Level for future reference if needed in production environment..e., The code should be written so way as to prevent exceptions from being swallowed by developers.
      }       /* End of try catch block */        
}     /** end method insertSecure **/  //End Method Declaration       `