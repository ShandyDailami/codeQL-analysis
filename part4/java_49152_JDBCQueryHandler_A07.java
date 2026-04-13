import java.sql.*;   // Import Statements for all database related operations i.e., Connection,Statement etc..   
public class java_49152_JDBCQueryHandler_A07 {    
       public static void main(String[] args) throws SQLException{     
           String url = "jdbc:mysql://localhost/test";  /* Replace with your DB URL */  
           String username="root"; //Replace root as per MySQL setup.    (username, not user for security sensitive operations in this case.)    
           String password="password";//Password related to the database server which is mentioned above 'localhost/test' .  You need correct one according your DB credentials  
         try {        /* Begin of Try block */      //Establishes connection with MySQL Database.      
             Connection conn = DriverManager.getConnection(url,username ,password);   
              String SQL="SELECT USERNAME FROM EMPLOYEE WHERE AGE > 30"; 
            Statement stmt =  conn.createStatement();      //Create a new statement .   (SQL Query execution is here)      
             ResultSet rs =stmt.executeQuery(SQL);           /* Execute the query and store into result set */   
              while (rs.next()) {                            ///Iterate over each row fetched by JDBC     //Print user name of employees older than 30 years   .      println("Name: " + rs.getString(1));       }        conn.close(); /* End connection to the database */
         }} catch (SQLException e) {          /// Catch statement for handling SQL Exceptions    (.e at start will explain you in detail about what exception is.)  .   // Handle any errors that may occur during execution of a query, update etc..      }            finally{     /* This block ensures the connection to database gets closed whether an error occurred or not */
         if (conn != null) { conn.close();}        try    {/* Beginning Of Finally Block*/  // Code which you want be executed at last of all operations,whether it is query execution success/failure etc..     }} catch(SQLException ex){ex.printStackTrace();}}