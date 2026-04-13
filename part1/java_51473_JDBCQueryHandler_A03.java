import java.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
  
public abstract class java_51473_JDBCQueryHandler_A03 {
     private DataSource dataSource; // Let's assume we are using a Spring bean for this in our configuration file, you should replace it with your actual implementation 
     
     public void setDataSource(DataSource dataSource) {   
         this.dataSource = dataSource;  
     }
      
     protected abstract String getQuery(); // This is an abstraction and we will be overriding in our subclasses to provide the required SQL query for each operation 
     
     public void execute() throws SQLException{       
          JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
          
         String sqlQuery= this.getQuery(); // Calling method implemented by concrete classes in order not to repeat code and keeping it DRY principle 
             
             int rowsUpdated = 0;    /* Assuming you want a specific type of update, replace with your requirement */      
                     
          Connection connection = dataSource .getConnection();  
           try {    
            PreparedStatement pstmt=connection.prepareStatement(sqlQuery);       
               // Here we are just executing and not committing the transaction here as it is a simple example 
              rowsUpdated =  pstmt.executeUpdate();    /* Note: This will return updated records count */  
           } catch (SQLException e) {      
             System.out.println("An error occured while updating data to database : "+e);        // Here I am assuming you want logging the exception 
            throw new SQLException(e.getMessage());     /* Re-throwing for upper layers */     
           } finally{  
                connection.close();    // Closing connections here as they are not needed after processing is done anyway            
          }}       
}