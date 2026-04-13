import java.sql.*;   // Import required classes/libraries
// ... Other import statments if necessary... (e.g., MySQL JDBC driver)
    
public class java_48720_JDBCQueryHandler_A03 {   
       private Connection conn;     
       
           public void connect(String url, String username, 
                   String password){   //Establish connection method using URLs and credentials parameters             
                     try{               
                         this.conn = DriverManager.getConnection(url ,username,password);                   
                      }catch (SQLException ex) {                 
                        System.out.println("Error in connecting to the database: "+ex );  //Handle SQL Exception   });        
                       }}       
    
    public ResultSet executeQuery(String query){              
           try{               
              Statement stmt = conn.createStatement();      
             return stmt.executeQuery(query);                 }catch (SQLException ex) {                   System.out.println("Error in executing the Query: "+ex );  //Handle SQL Exception                  });         }}         
     public void executeUpdate(String query){                try{               Statement stmt = conn.createStatement();      
             stmt.executeUpdate(query);                      }catch (SQLException ex) {                   System.out.println("Error in executing the Update: "+ex );  //Handle SQL Exception                  });         }}   
           
        public void closeConnection(){                          try{               conn.close();                              }catch (SQLException ex){System.out.println(“Could not be closed" +ex);}},                 };         
}