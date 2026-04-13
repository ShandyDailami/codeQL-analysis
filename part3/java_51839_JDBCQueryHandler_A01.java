import java.sql.*;   // Importing necessary classes   
class java_51839_JDBCQueryHandler_A01 {    
      static final String DB_URL = "jdbc:mysql://localhost/test";        
      static final String USERNAME ="root";         
      static final String PASSWORD = "";  /* Minimum required for using root user */  
      
    public void createConnection() {     // Method to establish a connection with the database.       
           try{            
                 Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);             
                  System.out.println("Connected");                }               catch (SQLException e){                  
                        e.printStackTrace();                       // Catching any SQL Exception if there is an issue with connection                   
             }           
    }}     /* Creates Connection */