import java.sql.*;  // Import the necessary Java libraries, they are all standard library so no need to import external frameworks like Spring or Hibernate here    
public class java_52452_JDBCQueryHandler_A01 {   /* Start with 'Java' */   
      private static Connection connection = null;       // Define a singleton database connections.  This is thread safe in java, only one instance of it will be created at any time which can then use for query execution and also closed once the operation has been complete (Closed automatically when JVM goes out)    
  
      private static final String url = "jdbc:mysql://localhost/test";        // Setup your database connection details here   
       private static final String username="root ";  /* Replace with root user */         public static final String password  = "";          // Enter Your Password Here.    
  
      /** Connects to the MySQL server*/            Connection connect(){           if(connection == null || !connection.isValid()){             try{                 connection = DriverManager.getConnection (url, username ,password);                  }catch (SQLException e) {                System.out.println ("Error in connecting Database " +e);}}          return  connection; }}