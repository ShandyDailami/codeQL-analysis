import java.sql.*;   // Importing necessary Java packages for database interactions via PreparedStatement objects etc..   
public class java_52360_SessionManager_A03 {     // Defining a public static session manager that interacts with the underlying JDBC resource e.g., datasource, connection pool and so on... 
private Connection con = null;         
   private Statement stmt=null;       
// Creating our DatabaseConnection object using method initialize() which initializes all objects required for interactions    // Initialize should be called when we want to open a new session.    
public void startSession(){             /* Starts the Session by opening connection and statement*/  try { con = DriverManager.getConnection(url, userName, password); stmt=con.createStatement(); } catch (SQLException se) { handleExceptions(se);}   // End Try block      
// Close Connection in case of any exception        /* Closes the session by closing connection and statement */  try{ con.close();stmt.close();    }catch(SQLException se){handleExceptions(se);     }}