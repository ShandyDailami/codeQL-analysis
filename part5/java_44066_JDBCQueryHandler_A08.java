import java.sql.*;
public class java_44066_JDBCQueryHandler_A08 {   // Class name should be a noun in Java (camel case is not allowed)
    public static void main(String[] args){  // Method must start with 'main' and follow the standard practice of starting it by convention, ie., firstStatement. Etc...    
        String url = "jdbc:mysql://localhost/dbname";   /* Change this to your database URL */   
        String username="username_here", password="password_here";  // Replace with actual values required for the DB user and their passsword, typically stored in a secure place such as environment variables or .properties file.    
        
		/* Establishing Connection to Database using JDBC */   
        try {   /* Start of 'try' block: ensure any exceptions that occur within this scope are caught by the finally clause (closes connection) and not re-thrown further in an uncaught exception handler.  This is why we wrap our operations inside a Try/Catches statement for proper handling */
            Class.forName("com.mysql.cj.jdk.JdbcDriver");   /* Loading MySQL Driver - required to establish connection with database server (MySQL)*/    // Change this depending on the version of JDBC and what DB you're using 
                                                                                    // For example: "org.apache.commons.dbcp2" for Apache, or 'com.mysql.jdbc.' if it is standard MySQL db connection    
            
            Connection con = DriverManager.getConnection(url , username , password);   /* Establish a database-linked connection to the server */    // URL of your DB Server and user details – change accordingly as per requirement       
                                                                                     // Use getconnection() for any JDBC operations, it returns Database Connection object not null if successful. If unsuccessful then throws SQLException    
            
            /* Execute a Query using Statement */   
			/* PreparedStatement can prepare an SQL statement to be executed several times with different parameters (providing the correct parameter values)*/  // Use when you want your code more readable and reusability  
			                                                       // It also has ways of handling transactions, which is not covered here in our example.   
			Statement stmt = con.createStatement();     /* Create a Statement object for database interactions */      // Using this statement will execute SQL Query/s – change accordingly as per requirement      
            
            ResultSet rs  =stmt.executeQuery("SELECT * FROM Employee");   /** This line is just fetching data from DB and not changing it, you should replace the query with your actual sql operation */    // Change this to use in place of "select" command – select different commands as per requirement    
            
            /* Print out all rows returned by database. Here we are looping through ResultSet*/  
			while (rs.next()) {      /** The next() method retrieves the result set from a statement object and moves to an individual row in this Result Set */    // Change accordingly as per requirement    
                System.out.println(rs.getString("EmpName")); /* Get values of each column by calling getString function for appropriate columns ('columnname')*/   // change 'empId' & ' Emp Name here according your table design  and replace them with actual names you need to use in place as per requirement
            }    /** End While loop */      // Change accordingly based on the total rows fetched by rs.next() function    
            
			con.close(); /* Close connection after using it, this is not necessary when we are done with ResultSet and Statement objects*/   // Replace 'empId' & column names here according to your table design — replace them as per requirement    } catch (SQLException e) {      /** Catch block for SQLExceptions */
            System.out.println("An error occurred while connecting or executing a query."); /* Handling errors in case of any issues*/   // change 'empId' & column names here according to your table design — replace them as per requirement    e.printStackTrace();      /** Printing the exception details */
        } catch (ClassNotFoundException cnfe) {       /** Catch block for ClassNotfoundExceptions - handling when jdbc driver is not found*/   // change 'empId' & column names here according to your table design — replace them as per requirement    System.out.println("JDBC Driver was not found.");
            cnfe.printStackTrace();      /** Printing the exception details */ }     /* End of Try-catch block*/   // Change accordingly based on how many 'try'-'catches'/finally blocks you have — replace them as per requirement    }} ;/* end statement for main method and closing bracket is removed if not used.