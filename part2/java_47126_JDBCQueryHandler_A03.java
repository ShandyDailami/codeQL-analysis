import java.sql.*; // import necessary packages to establish a connection and execute SQL commands (optional but recommended) with JDBC in Java applications
public class java_47126_JDBCQueryHandler_A03 {   
// This is our main method which will be used for executing queries using PreparedStatements 
 public static void databaseQuery(String query, String dbUrl , String userName, String password ) throws SQLException{ // declare the methods and variables as required above.  
        Connection conn = null;    
    try {     
         Class.forName("com.mysql.cj.jdbc.Driver");  // load driver for MySQL database (or any other JDBC Driver) used in your URL, you need to set it up first before executing this line of code      
        conn = DriverManager.getConnection(dbUrl , userName, password);   // Connects the java program with a DB using provided credentials     
    } catch (ClassNotFoundException e1) {                    // Handle any exceptions that may occur during driver setup  on Windows System    
         e1.printStackTrace();                              
       }       
 if(conn != null){                                         // Make sure to close the database connection after use  
          conn.close();                                     
      }           
    PreparedStatement pstmt = null;                     
 try {                                                   /* This is our query which will be executed on MySQL server */ 
     String sql = "INSERT INTO emp(emp_id,firstName ,lastname) VALUES (?, ?,)"; // Define the SQL command that we want to execute  
      pstmt  = conn.prepareStatement("insert into employees (employeeId, firstName, lastName); values ('"+1 + "',"John "Jones", 'Manager');  ");    /* This is where our sql string and data are set up */        
     //pstmt =conn . preparestatement(sql2 );             // Execute the prepared statement on server side  
      } catch (SQLException e) {                        /// Catch any SQLExceptions that may occur during query execution  in Windows system.    else block is executed if no exception occurs while executing above try blocks    
            System . out . println (" Error :" +e); //This line will be printed and also execute when the catch condition fails to run         }          finally {                          /* This 'finally' always runs whether an Exception or not, it can contain clean up tasks */  conn.close();             pstmt. close ( );       
            try{conn = DriverManager . getConnection("jdbc:mysql://127.0.0_1/root", "password"); }catch(Exception e){System.out.println ("Error while getting connection.");}    //Finally block  */   catch in Java or the other language programming, there is no equivalent of a finally here as it will execute even if an exception occurs during program execution
             return;                  });     };};                      /* Closing curly brackets for try and closing parenthesis after statement ends.*/ }                   //Ending class    */  public static void main(String[] args) {   Main m = new Main();      String dbUrl="jdbc:mysql://127_0_1/root";
     string userName("root");          try{m,databaseQuery (dburl); }catch(){System.out.println ("Error while executing query.");}}};    //Ending main method */  };   End of the program                     /* Closing curly brackets for all classes and their methods at ends*/