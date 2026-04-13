import java.sql.*;   // Import necessary classes from package 'java.sql' and its subpackages such as Statement, PreparedStatement etc...    
    import javax.sql.*;  //Import the JDBC Connection Pooling interface in order to access databases (JBPM-based on Hibernate)..         
                       /*This is a pseudo code example assuming you have already created and named your database connection using DriverManager*/  
Connection con=null;    
    try {     
        Class.forName("com.mysql.cj.jdbc.Driver");  // Load the MySQL JDBC driver for Oracle DB Connection...            
         String url = "jdbc:mysql://localhost/testdb";            /* Assuming we are using mysql db and localhost as host*/    
        con= DriverManager.getConnection(url,"username","password ");   /** The username & password required to access the database */          //** Get a Connection from pool  ...      
         Statement stmt =con.createStatement();      /* Create 'statement' that can execute mutiple SQL commands in a session    **/    
        String sql="SELECT USERNAME FROM EMPLOYEE WHERE AGE>30";   // Define the query...          /** Execute Query and Store Result */  stmt.executeUpdate(sql);      /* Send queries, statements or updates to Database using this statement object..    **/
        }catch (Exception e) {e.printStackTrace();}                ** Catch exception if there is any ....**     finally{if(con!=null){try{ con.close();  //Close the connection...   /** Close a Connection after use */             stmt.close();      /* close Statement object*/ }catch (SQLException se) {se.printStackTrace();}}                 
         try {Thread.sleep(20);} catch (InterruptedException e){e.printStackTrace();}}}  // Add delay for example..   ** Note: This is a pseudo code and can't be run without JDBC driver or Database connection...**    }                                                       */                    /** End of program ...*/