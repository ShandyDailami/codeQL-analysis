import java.sql.*;   // Import the necessary classes   
public class java_51784_JDBCQueryHandler_A03 {    
       static Connection conn = null;         
      public void dbConnection() throws SQLException{       
         String url="jdbc:mysql://localhost/testdb"; 
         String username= "root";   //Change according to your database user   
         String password="password12345!" ;     // Change the Password accordingly         
       conn = DriverManager.getConnection(url,username, password);        }           public void dbOperation() {      try{            System.out.println("Running DB operation..."+conn );              Statement stmt=null;             String queryString1 =  "SELECT USERNAME FROM EMPLOYEE WHERE AGE = ?" ;     Object[] params_nameAge  = new    Integer[]{20};     
        // Prepare the statement         System.out.println("Running DB operation..."+conn ); stmt= conn .prepareStatement(queryString1);          for (int i = 0;i <params_nameAge.length ;   i++ ){            if(!stmt !=  null){            
        // Execute the statement                 stmt.setInt  ("id", ids[j]);                  }               System .out .println("Record inserted " );              conn    .close();          }}catch(SQLException seqScn   []     ){seqScn      ...}       catch (Exception ex) {ex...}}