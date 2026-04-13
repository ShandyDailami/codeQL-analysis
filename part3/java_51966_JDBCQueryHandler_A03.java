import java.sql.*;   // Import necessary classes from standard library   
public class java_51966_JDBCQueryHandler_A03 {     // Define a new public static-accessible method named "JDBCQueryHandle"      
      private Connection connection = null;        // Declare and initialize variable for database connections         
         try{                  /* Enclose the code into 'try' block to handle exceptions */   
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC Driver  
               connection = DriverManager.getConnection( "jdbc:mysql://localhost/testdb?useSSL=false", "user1","password" );     /* Get a Connection object */      
             System.out.println("Connected to the database\n");  // Print success message if connected successfully     
          }catch (Exception e){                  // Catch block for handling exceptions when DriverManager is not available or there are problems connecting  
               e.printStackTrace();           /* If exception occurs print out error details */     System.out.println("Failed to connect database\n");  // Print fail message if connection fails      }         
       try(PreparedStatement pstmt =connection .prepareStatement("INSERT INTO users (name, email) VALUES (? , ?)")){   /* Prepare a statement for insert operation */     String name="John Doe";        string email= "john@example.com ";    // Define the values to be inserted 
         int id = 0;             pstmt .setString(1,name);          pstmt . setString (2 ,email );                /* Set up parameters and execute statement */     }catch (SQLException e) {        System.out.println("Error in query execution: " +e ) ;    // Catch block for handling SQLExceptions 
       finally{         connection.close();            try(Statement stmt =connection .createStatement()){           /* Prepare a statement to get data from the database */      String sql="SELECT name,email FROM users";        ResultSet rs;          Try-Catch block for handling resultset and printing them 
                 rs  =stmt.executeQuery(sql);             while (rs .next()) {               System.out.println("Name : " + rs .getString ("name") );              // Extract name from the ResultSet object           }            }}                  /* Close connection to database */          catch {}     close();