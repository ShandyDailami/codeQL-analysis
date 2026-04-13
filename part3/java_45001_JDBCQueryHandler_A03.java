import java.sql.*;   // Import Statement, PreparedStatement and ResultSet classes   
public class java_45001_JDBCQueryHandler_A03 {     // Beginning of public static void main(String[] args) block for testing purposes only     
       private Connection conn;           // Declare connection object 
        String url = "jdbc:mysql://localhost/test";   // MySQL URL   
         String username="root", password="password1234567890!@#$%^&*()_+-~`|}{[]:;?><,./ ";     
           try {                     // Beginning of a 'try' block for handling possible exceptions 
                Class.forName("com.mysql.cj.jdbc.Driver");    // Load MySQL driver  
                   conn = DriverManager.getConnection(url ,username, password);     /* Create connection */      
                  System.out.println("\nConnected to database!\n" );  }      catch (Exception e) {          
               System.out.println("Error in Connection..\n");         // Catch exception if there is any error  
                       try { conn = DriverManager.getConnection(url ,username, password);     /* Create connection */      
                        System.out.println("\nConnected to database!\n" );  } catch (SQLException se)    {}        };      void runQuery()          // Method for running SQL query using Statement and PreparedStatements   try {           Pstmt = conn .prepareStatement("INSERT INTO EMPLOYEE(ID,NAME,DEPARTMENT,SALARY) VALUES (?, ?, ? ,?)"); 
               /* Bind values */         Pstmt.setInt(1, id);      //Set the parameters  
                           Pstmt.setString(2,name );   
                            Pstmt.setString(3,dept);      
                             Pstmt.setDouble(4,salary     ) ;  /* Binding values */          try {             /* Executing statement in PreparedStatements manner*/        // execute insert using preparedstatement   it will prevent SQL Injection attacks    exe = conn .prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");     
           Pstmt.setInt(1, id) ;         try {     /* Execute the statement */          ResultSet rs  = pstmt.executeQuery();   // Executing query and get result set  while preventing SQL Injection attacks    } catch (Exception e){}        };                   if(!conn.isClosed() ) conn .close(); });