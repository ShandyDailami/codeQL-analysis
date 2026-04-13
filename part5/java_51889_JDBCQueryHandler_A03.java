import javax.sql.DataSource; // assuming you are using a DataSource, e.g., HikariCP for MySQL 
   import java.sql.*;    // For ResultSet and Statement interfaces    
public class java_51889_JDBCQueryHandler_A03 {
       private final static String URL = "YOUR_DATABASE_URL";     
       private final static String USERNAME="USERNAME";             
       private final static String PASSWORD="?PASSWORD?";             // This will be password-protected    
    DataSource ds ;// assuming you are using HikariCP for MySQL  data source.  
       
      public java_51889_JDBCQueryHandler_A03(DataSource aDS) {        
          this .ds =aDS;}      
          
            /** Executes an SQL query with parameterized values */    
    void executeSQL (String sql, Object... params){                   //params is the placeholders in your statement string 
        try (Connection con  = ds.getConnection();                   
             PreparedStatement pstm =con .prepareStatement(sql)) {  
            for (int i = 0; i < params.length ;i++ ){               
               pstm.setObject((i + 1),params[i]);                   // set each parameter  and start from index+= 1    
           }     
          pstm .executeUpdate();}                                  // execute the SQL statement   catch Block not required here because it is inside try-catch block where we prepareStatement    */            else{throw new IllegalArgumentException("Invalid sql")};                    });        }}  Catch blocks and error handling omitted for brevity.