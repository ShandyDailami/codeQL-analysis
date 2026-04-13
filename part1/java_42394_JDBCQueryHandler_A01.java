import org.springframework.jdbc.core.*;
import javax.sql.DataSource;
 
public class java_42394_JDBCQueryHandler_A01 {
    private DataSource dataSource; // injected by Spring IoC container, or manually set here if you have it configured in your application context file (e.g., via XML configuration)  
    
    public void execute(String sql){      
        SimpleJdbcCall call = new SimpleJdbcCall(dataSource).withSqlParameterSource(new SqlBuilder().addValue("sql", String.class, sql));  // Adding parameters to the SQL query by using Spring's JDBC Template (Spring-jdbc) for handling PreparedStatement
        CallResult result = call.execute();  
         if (!result.wasSuccess()) {         
            System.out.println(String.format("Failed: %s",  e)); // Print failed query details to console   
             return;    
         }      else{      
              ResultSet rs= result.getResultSet();        while (rs.next()){  
                 String user = rs.getString("username");            System.out.println(user);           }}  // Print the fetched users details to console    return;    
          }      catch (Exception e) {       printStackTrace(() => "Failed: ", true, false));}}// Catch exceptions and show detailed error message if any   public static void main() throws Exception{ new JDBCQueryHandler().execute("select username from Users where password=?");  }}