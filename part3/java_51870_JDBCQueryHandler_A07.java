import java.sql.*;   // Import necessary packages from the 'Java' Standard Library, e.g., PreparedStatement and ResultSet objects etc...   
    
public class java_51870_JDBCQueryHandler_A07 {      
      public static void main(String[] args) throws SQLException{ 
          String url = "jdbc:mysql://localhost/mydatabase";   // Setup the database connection, you can use your own URL and DB name here. In this case we're using MySQL locally on localhost with myDatabase as our db Name   
          
        Connection conn=null;     // Declare a new 'Connection'-variable to hold JDBC connections... 
        
          try{       // Begin of the Try-catch block for exception handling  
             System.out.println("Connecting to database...");     
             conn = DriverManager.getConnection(url, "username", "password");    /* Connects your program with MySQL server */    
              
            if (conn != null) {  // If the connection is established successfully...  
                System.out.println("You are connected to database...");     
                
                  String sql ="SELECT * FROM Users WHERE UserName Like 'John%'";    /* Set up your SQL statement */      
                   PreparedStatement pstmt=conn.prepareStatement(sql );     // Create a preparedstatement object.. 
                    ResultSet rs;                                             // declare the resultset  
                    
                  System.out.println("Executing Sql...");     
                     
                       /* Execute SQL query */   
                        try {                                  pstmt .executeUpdate();      
                               } catch (SQLException e)        {e.printStackTrace() ;}                   // Catch if the statement fails  
                     System.out.println("Query execution successful");  rs =pstmt.executeQuery(sql);    /* Execute SQL query and get result set */         while (rs .next())      print details of each row using 'printdetails' method     };        conn.close();       // close the connection after use  
          }catch { e=>{e}};                                  System.*;out,println("Exception occurred...");  /* Catch Exception if any occurs */    finally {}                                                                                               end;}               }} ;)         );              });                           )};