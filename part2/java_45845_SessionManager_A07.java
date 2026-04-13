import java.sql.*;  // Database connectivity and SQL exceptions are handled here only for clarity of example      
public class java_45845_SessionManager_A07 {       
     private static Connection connection;          
     
     public void openConnection(String dbURL, String userName, String password){         
         try{             
             this.connection = DriverManager.getConnection(dbURL ,userName  ,password);               
                         }                   catch (SQLException e) {              
                          System.out.println("Error while connecting to database : " +e );            // Handling exceptions      };   });    else if (!isClosed())              this .close();        }}         public void closeConnection(){          try{             connection = DriverManager.getConnection(dbURL, userName , password);  }catch (SQLException e){           System.out.println("Error while closing database : " +e );}}              
     // Method to check if the Connection is closed              boolean isClosed() {return this .connection == null; }}         public void close(){                try{             connection = DriverManager.getConnection(dbURL ,userName, password);  }catch (SQLException e){            System.out.println("Error while closing : " +e );}}    });