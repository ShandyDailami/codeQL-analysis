import java.sql.*;
public class java_51604_JDBCQueryHandler_A08 {  
    private Connection connection;
    
    public void connect(String url , String username , String password){      
        try{            
            this.connection = DriverManager.getConnection(url,username,password);                  
        }catch (SQLException e) {                      
           System.out.println("Error connecting to database: " +e );                
         //TODO : Handle the exception appropriately in a real application   
       }         
     }  
      public void disconnect(){                     
            try{                if(this.connection != null && this.connection.isClosed())                  {                  
             connection.close();               }}catch (SQLException e){                        System.out.println("Error closing database: " +e );                       //TODO : Handle the exception appropriately in a real application    }      
      } 
     public ResultSet executeQuery(String query)   {                     try{                  return this.connection.createStatement().executeQuery(query);}}catch (SQLException e){                    System.out.println("Error executing Query: " +e );                      //TODO : Handle the exception appropriately in a real application    }     
     public void executeUpdate(String query)  {                     try{                  this.connection.createStatement().executeUpdate(query);}}catch (SQLException e){                    System.out.println("Error executing Update: " +e );                      //TODO : Handle the exception appropriately in a real application    }     
}