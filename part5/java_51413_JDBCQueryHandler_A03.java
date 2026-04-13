import java.sql.*;
public class java_51413_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{  
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");     //Provide your DB URL, username and password here      
        
        String selectSensitiveDataQuery="SELECT * FROM SensitiveTable WHERE id IN (?)";  /* Providing a placeholder in the query */  
                PreparedStatement pstmt = connection.prepareStatement(selectSensitiveDataQuery);    //Create prepared statement for SELECT operation    
                
         List<Integer> listIdsToBeSelected=new ArrayList<>();        //Provide ids here to be selected from SensiteTable  (Example: [1,2])  
                pstmt.setInt(0 ,listIdsToBeSelected);          /* Bind the parameter value */     
         ResultSet rs =pstmt .executeQuery() ;           //Execute a query and get result set    
                  while(rs.next())  {            /*** Process each row of fetched data ***/      
                      String sensitiveData=rs.getString("sensitive_data");   /*Provide column name here for the sensitivy */    System .out.println ( "Sensitive Data :"+sensitiveData ); }     //Print out your results         connection close and disconnection are also handled by JDBC
                  pstmt.close();  rs.close();   /* Close statement, result set after use*/      });}            catch(SQLException e){ System .out.println ("Error: "+e);}}    }     Closing the connections ensures that we don't leave any hanging database connection open