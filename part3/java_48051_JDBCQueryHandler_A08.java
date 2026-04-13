import java.sql.*;    // Import necessary classes for JDBC Database Connection (DriverManager) and Statement/ResultSet objects (.executeQuery, .prepareStatement etc.)
                  
public class java_48051_JDBCQueryHandler_A08 {    
      public static void main(String[] args){        
        String url = "jdbc:mysql://localhost:3306/mydatabase";   // MySQL JDBC URL and Database Name   
        String username="root", password="password12345!@#$%^&*()_+<>?";  // Your MYSQL User, you can use any valid mysql user    
          
         try {         
             Connection con = DriverManager.getConnection(url ,username,password);    /* Establishing the connection */  
               String SQL="SELECT * FROM mytable WHERE condition";      // Security-Sensitive Operation  -> This is a simple example and you can replace 'condition' with your actual security sensitive operation e.g., user_id = ##;        
                PreparedStatement ps  = con.prepareStatement(SQL);    /* Preparing the statement */  
             ResultSet rs =  ps.executeQuery();     // Execute Query       
               while (rs.next()) {      // Processing each row in result set      
                  System.out.println("User ID: " + rs.getString(1));  // Assume that user_id is a column of table mytable and it's indexed as 'ID'. Replace accordingly if your columns are different         }              con.close();      /* Closing connection */  
             }           
          } catch (SQLException ex) {     // Handling any SQL Exception           System.out.println("Error in Connection:" +ex);  If you want to handle exceptions        };    }}`