import java.sql.*;  // Import necessary classes from Java Standard Library (JDBC)  
                   // It includes Database Connectivity API, ResultSet interface etc..   
class java_53113_JDBCQueryHandler_A08 {      
     public static void main(String[] args){     
         Connection conn = null;                /* Define a connection */       
          try{                                                
              Class.forName("com.mysql.jdbc.Driver");  // Load MySQL driver  
               String url="jdbc:mysql://localhost/testdb";    // Database URL    
                                          System.out.println(url);         /* Connection details */               
             conn = DriverManager.getConnection (url,"user","password123456");  /** Connect to the database using provided credentials*/              
                 if (conn==null){                       /** Check connection before processing further query **/                   System.out.println("Error in establishing Connection!");                    return;                }              else{                      // Beginning of a transaction       ...   }} catch(Exception ex) {ex.printStackTrace();}   
             PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO EMPLOYEE (ID,NAME,DEPARTMENT,SALARY) VALUES (?, ? ,? )");  /* Create prepared statement for inserting data into the database */              try {     // Beginning of a transaction       ...  
             pstmt.setInt(10234567);          /** Sets parameter value*/                 System.out.println("Parameter values are set!");                } catch (SQLException se) {}  finally{    /* Ending Transaction */      try { conn.close();}catch (SQLException se){se.printStackTrace();}   // Close the connection after transaction processing }}