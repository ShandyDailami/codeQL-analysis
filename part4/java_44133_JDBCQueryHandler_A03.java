import java.sql.*; // Import necessary classes from JDBC library to establish a Connection, Statement etc.,
  
public class java_44133_JDBCQueryHandler_A03 {    /* Start of Program */
     public static void main(String[] args)  {          /* Creating Main Function for Test Case*/     
        String url = "jdbc:mysql://localhost/test"; // Database URL to connect. You may need change according your server and database details        
  
       try (Connection conn =  DriverManager.getConnection(url, "username", "password")) {  /* Creating Connection */   
           Statement stmt = conn.createStatement();          /**/     
               ResultSet rs = stmt.executeQuery("SELECT * FROM table"); // Executed Query to fetch data from database        
            while (rs.next())             /// Iterating over each row in the result set      
                System.out.println(rs.getString("column_name"));  /* Printing column values */       
           } catch (SQLException e) {                     /**/     
               throw new ExceptionInInitializerError(e);   // Throw an exception if there is any error while connecting to database      
            }   
     }}                          /******** End of Program ********/  /* Closing the Main Function */