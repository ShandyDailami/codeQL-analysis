import org.springframework.beans.factory.annotation.*;
import javax.sql.DataSource;
...  // Import necessary libraries here....  
     ...// Data source bean is auto-created by spring container when using JdbcTemplate and similar beans too if not already present in the context..   
public class java_45031_JDBCQueryHandler_A03 {
@Autowired private DataSource dataSource ;        /* Spring Bean for Database connection */ 
... // Constructor, setters & getter methods here ...  
     public void executeSQL(String sqlStatement) throws SQLException{            
         try (Connection conn = this.dataSource.getConnection()){           
                PreparedStatement pstmt =  conn.prepareStatement(sqlStatement);         
                  // Execute the query..          
                 ResultSet rs  =   pstmt .executeQuery();              
                     while(rs.next()) {                  
                         System.out.println("Result "+rs.getString('column_name'));  }                ;     }} catch (SQLException e) {} finally{    // Close resources here...}}