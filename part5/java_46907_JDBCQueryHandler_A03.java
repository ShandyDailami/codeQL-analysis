import java.sql.*;   // Import necessary Java libraries for JDBC (Java Database Connectivity) 

public class java_46907_JDBCQueryHandler_A03 {    // Declare a public static main method to start execution of program and run function below it in the code block at end    
      
      private String url = "jdbc:mysql://localhost/test";   // JDBC URL for MySQL database (replace with your actual address) 
      private String username="root", password="password";    // Username and Password to access DB(Replace 'username' & 'password')      
         
     public static void main(String[] args){        // Main method that will start the execution of program  
         VanillaJdbcQueryHandler jdp = new VanillaJdbcQueryHandler();  // Create an object for class (jdbchandler)     
                 if((args.length == 3 && "user".equals(args[0]) && "password123!".equals(args[1]))){   /* Password check */   
                    jdp.executeQuery("SELECT * FROM Employee");  // Execute JDBC Query (replace with actual SQL query)         } else {        System.out.println("\nUsage: java VanillaJdbcQueryHandler user password\n");     return;   }}      private void executeQuery(String sql){    /* Method to perform the select operation */      
           try{  // Create a Try block for exception handling          Connection conn = null, Statement stmt=null        String urlName  =url + database ;         Class.forName("com.mysql.cj.jdbc.Driver");     conns=  DriverManager.getConnection(url ,username , password);          
               // Prepare statement for execution   if (conns != null) { stmt = conn .createStatement(); }       ResultSet rs  =null;  try{            /* Execute SQL query */         System.out.println("Connecting to database..." + urlName );      conns =  DriverManager.getConnection(url ,username, password);
               // Prepare statement for execution if (conns != null) { stmt = conn .createStatement(); }       rs  =  /* Execute SQL query and get the result set */stmt.executeQuery("SELECT * FROM EMPLOYEE");           while ((rs  =/* Fetch data from ResultSet*/  rs.next()) ){ System.out.println(rs.getString('EMP_NAME'));}} catch (SQLException e) {          // Catch and handle any SQL exception  
                /* Close resources */     if (stmt != null){ try { stmt.close(); }catch (SQLException se){} }    if (conns ！=  null ){try {@ conn .close(); }} System.out.println("\n Closing connections...");       e.printStackTrace();}} catch(SQLException se) {}  
               // Close resources        finally { /* Execute any clean-up tasks */     try{ if (stmt !=null){ stmt.close(); }  conns = null;}catch(SQLException se){}    }}//end of main method         System..println("Exiting the application");}};