import java.sql.*;   // Import necessary classes for SQL queries, connection etc.,   
                  
public class java_51263_JDBCQueryHandler_A01 {    
       private Connection conn;        // Instance variable to hold the database connectivity object     
        
       public void establishConnection(String dbURL) throws SQLException{          // Method to connect with DB          
                this.conn = DriverManager.getConnection(dbURL);             
                                  }  
                        
                        private boolean checkPasswordStrength (String password){  /* This method checks the strength of given Password */   
                                if ((password == null) || !password.matches("^.*[0-9].*")) {     // Checks for at least one digit     
                                        return false;          }                         else{       /// If no digits, check again using a pattern       
                                                Pattern p =    Pattern.compile(             "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,})");      // Password complexity:  at least one digit and upper case letter     return   password       .matches (p); }
                                public ResultSet executeQuery(String query){              /* Method to run SQL queries */          try {                  this.conn = DriverManager.getConnection("jdbc:"+dbURL, "username", "password");            // Use the database connectivity object and username/passwords for authentication      Connection con= conn;          
                                                                                            ResultSet rs=  con .createStatement().executeQuery(query);          while (rs != null) {                    System.out.println("Result:  ");                PrintWriter pw = new    java.io.PrintWriter(System.out, true);               // Use print writer to write output of the result into console
                                                                                            rs .printSQLException(pw );              } catch ( SQLException e) { System.out   .println("Error in executing query " +e  ) ;}       finally{this.conn.close();}}    })     // Close connection when done           }}         'QueryHandler'