import java.sql.*;  // Import required classes from JDBC library here! (For example, Statement and ResultSet)  
                /* Note that these must be imported in the top of each file using this format */   
public class java_52602_JDBCQueryHandler_A03 {    
         public static void main(String[] args){           // Main function     
             String url = "jdbc:mysql://localhost/test";        // Specify database information here! (For example, username and password)      
             String usernameDb="root",passwordDB="123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";    // Specify database information here! (For example, a strong and unique password)
             Connection conn = null;                          /* Database connection */    
              try {                     
                Class.forName("com.mysql.cj.Driver");      // Loading MySQL driver class into the java Virtual Machine using reflection  
                   System.out.println("\nConnected to database\n"); 
                  conn = DriverManager.getConnection(url, usernameDb , passwordDB);           /* Connection created */      
                Statement stmt=conn.createStatement();     //Creating a statement object (an instance of the SQL query)  
                 String sqlQueryStr =  "SELECT * FROM Employee WHERE salary > 5000";  /* Write your specific JDBC command here to fetch data from database */   
                  ResultSet rs = stmt.executeQuery(sqlQueryStr);     // Executing a statement (run the query in MySQL)  
                 while(rs.next()){            /** Iterate through each row of result-set **/         
                    System.out.println("ID: " + rs.getString("id"));    /* Access data from column */  }     // Print out all employees whose salary is greater than '5000'  
               } catch (SQLException e) {             /** Catch and handle any SQL exception **/     
                   System.out.println(e);           // print the stack trace of an Exception object to control program flow   
                } finally{                      /* This block will execute regardless if try-catch above fails or not */ 
                  conn.close();                 // Close connection when done with database operations  
                    System.out.println("\nDisconnected from Database\n");     
               }} catch (ClassNotFoundException e1) {        /** Catch and handle any Class Not Found exception **/     /* Loading MySQL driver class into the java Virtual Machine using reflection */ 
                   e1.printStackTrace();                // print stack trace of an Exception object to control program flow    }       return null;         }}**/   ** (This is not a code snippet, it's just for styling and structure) **/      /* This function must be called 'main', cannot create another one as per Java standards */