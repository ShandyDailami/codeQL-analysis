import java.sql.*;
public class java_50651_JDBCQueryHandler_A07 {  // Class name is more descriptive here rather than A07_AuthFailure in this context  
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";    
    public Connection conn;       
      
      /* Connects to the database */         
         try {                     // Try block for connection                
            Class.forName("com.mysql.cj.jdk.Connection");  // Load MySQL JDBC driver          
             this.conn = DriverManager.getConnection(DB_URL, "user",   /*Username and password*/ );    
         } catch (ClassNotFoundException e) {                  // Catch block for Class not found exceptions             
            System.out.println("Sorry I am sorry! Failed to load the database driver:  \n" +e);         
             return;                                          
        }}                
      /* Closes Connection */   try{                     
         conn.close();                                        // Close connection at end of main method                   
    } catch(SQLException e){                          
       System.out.println("Sorry I am sorry! Failed to close the database: \n" +e); 
     }}     
               /* Inserts data */   public void insertData(){          try{                        // Try block for SQL operations                           
         PreparedStatement pstmt = conn.prepareStatement( "INSERT INTO Employee (id, name) VALUES (?, ?)" );                      
                    // Execute the statement with parameter values                 
             pstmt.setInt   (1 , 20);       /* First Parameter Index is set */         
         pstmt.setString    (2,"John");      /* Second and Third parameters are Set*/          
        } catch(SQLException e){            // Catch block for SQL exceptions                 
     System.out.println("Sorry I am sorry! Failed to execute the insert statement: \n" +e);          return;                   }}  finally {}}                             try{                                                                                       pstmt .executeUpdate();   /* Execute update */         } catch (SQLException e) {}                                // Do nothing if there is an error