import java.sql.*;   // Import the necessary Java classes from standard library packages...
// ...otherwise you'd have to manually include them, which could be error-prone depending on your project structure or setup: 
    import com.mysql.cj.jdbc.Driver;     /* For MySQL database */     
public class java_42268_JDBCQueryHandler_A01 {   // Create a public Java Class named 'JDBCQuery'...
// ...otherwise you could have accidentally created an actual SQL query in the above code, which is also not recommended: 
    private static final String DB_URL = "jdbc:mysql://localhost/test";       /* Your database URL */   // Local MySQL server test db. change accordingly to your setup...       
     private static final String USERNAME="root";      // Database username, replace with actual user in production environment..  (MySQL default is root)        
    private static final String PASSWORD = "password";       /* Your database password */   // Replace 'password' to your DB Password...       
     public Connection conn;          // Declare a connection object of type Connection for later use in the program.  (We will connect our query handler with this)        
    Statement stmt=conn.createStatement();      /* Here we are creating SQL statement that can be used to perform CRUD operations */       
     public ResultSet rs;           // Declare a 'Result Set' object for handling the result from database...  (We will use these results in our program)  
    String query = "SELECT * FROM Users";      /* Your actual SQL Query Here*/        
       try{          /* Start of Try Block */        conn=DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);           // Open Connection with database...  (Make sure you have added MySQL JDK driver in your project)                   stmt =conn .createStatement();      String sql;        
       rs =  stmt.executeQuery("SELECT * FROM Users");            /* Executing SQL Query */          System.out.println(rs);              // Print Result Set to Console...        }catch (SQLException e){                System.err.print_sqlExceptioNn();      }}