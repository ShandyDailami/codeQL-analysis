import java.sql.*;

public class java_47920_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // Use actual url here, replace 'local' with the database name in your case  
    private static final String USERNAME="root"; 
    private static final String PASSWORD= "";//Fill this field based on real situation. Leave it blank for root user access to DB (this is not recommended)    
     
       //Step1: Establish a connection with the database using DriverManager class of java sql  
        public Connection getConnection(){ 
            try {   
                return DriverManager.getConnection(DB_URL, USERNAME ,PASSWORD);         } catch (SQLException e) {          System.out.println("Error occurred while connecting to DB");      throw new RuntimeException();     }  
        }}//end of get connection method  //Step2: Prepare statement using the Connection object    and execute query with sql command via Statement or preparedstatement as shown below (Assuming a simple select SQL) in java.sql package                     public void performQuery(String Query){           try {           
                        Connection conn = new VanillaJdbcQueryHandler().getConnection();        //Establish the connection using our method 
                         PreparedStatement pstmt=conn.prepareStatement(Query);              //Prepare Statement    
                          ResultSet rs =  pstmt.executeQuery() ;                             //Executing a query and storing into result set (assuming simple select)    } catch (SQLException e){ System.out.println("Error occurred while performing the operation");}  }}//end of perform Query method   })();            
            this.performQuery(query);                                                       });}}};                         //End Of Main Method     In real scenario, you might use transaction manager or rollback and commit mechanism as part of application logic to ensure data integrity after each operation is completed successfully .  Please note that for production-level code security measures other necessary steps such a secure password handling (never store raw strings) etc are also needed.