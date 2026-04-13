import java.sql.*;
public class java_51264_JDBCQueryHandler_A03 {  // assuming we are using a Java-based database, so it should be safe to use as per A03_Injection principle here too!   
   private Connection connection;    
      public void openConnection(String url, String username, String password) throws SQLException{        
          this.connection = DriverManager.getConnection(url ,username ,password);  // Assuming we have a specific database driver and credentials available to us          
       }   
   public ResultSet executeQueryWithParams (String queryStr , Object... params){           
        try {              
             PreparedStatement statement=connection.prepareStatement(queryStr );         
                for(int i = 0;i<params.length ; ++i)                 
                    statement .setObject((i+1),  params[i]);                   //Setting parameters using set object method          
              return   statement .executeQuery();            }               catch (SQLException e){                 throw new RuntimeException("Error in executing Query",e);        }}          end of try-catch block      `    });