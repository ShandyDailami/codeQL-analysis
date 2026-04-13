import java.sql.*; // Import Statements from SQL API (Database connectivity) for JDBC to function properly    
public class java_51092_JDBCQueryHandler_A07 {  
    public static void main(String[] args){ 
        try{           
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "userName","password"); // Constructing the database Connectivity (Replacing with your DB details)    
             PreparedStatement preparedstatement  =connection .prepareStatement ("SELECT * FROM users WHERE name=?");  /* Replace '?' placeholders in this query */         
           String user ="User1";        
            ResultSet rs =  preparedstatement.executeQuery();// Execute the Query       // Send data to client     
        while(rs .next()){               System.out.println("Name : " + rs.getString ("name")); }             connection.close ();     /* Close database Connection */         return;   }} catch Exception e {e.printStackTrace();}}  /** End of Main Method **/     
}/***End class**/ VanillaJdbcQueryHandler`java' in Java code to run it on your server or local machine and make sure you replace the placeholders with actual database credentials, queries etc.. for security-sensitive operations. It is not a standard example but can be used as an illustration of how such tasks are performed using JDBC without frameworks like Spring/Hibernate