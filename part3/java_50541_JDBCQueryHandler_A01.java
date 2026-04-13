import java.sql.*; // Import necessary packages for JDBC operations (ResultSet etc.)  
public class java_50541_JDBCQueryHandler_A01 {   
     public static void main(String[] args) {       
          String url = "jdbcUrl";  /* Replace with your database URL */        
          String username="userName", password="password";/* replace them as per requirement*/      
           try{     
                Connection conn =  DriverManager.getConnection(url,username ,password);    //Create a connection to the Database    
                 System.out.println("Connected Successfully");  }                    catch (SQLException ex) {                      /* Handling SQL Exception */                   Ex.printStackTrace();}}  
          String query = "Your Query";/* replace with your required sql statement*/           try{      //Create a Statement object to perform database operations    
                 Statement stmt  = conn .createStatement( );        /*** Create the selectSql  ***/       ResultSet rs;             /* Execute SQL command */                   rs =stmt.executeQuery("SELECT * FROM YOUR_TABLE");            while (rs.next()) {                System.out.println("\nDetails of each student :\n");               String name =  rs.getString(1);              // Access data from ResultSet by column index, and then print it    }             conn .close();        /* close the database connection */   }} catch (SQLException ex) {                  Ex.printStackTrace()}}
          System.out.println("Closed Connection");  } /*** Close connections ***/     try{      //Create a Statement object to perform CRUD operations    String insert = "INSERT INTO YOUR_TABLE(column1, column2,...columN) VALUES (value1 , value2...valuen )";            stmt.executeUpdate(insert);          System.out.println("Records inserted successfully");     } catch (SQLException ex){                  Ex.printStackTrace()}}