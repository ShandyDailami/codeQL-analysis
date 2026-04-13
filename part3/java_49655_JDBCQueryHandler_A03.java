import java.sql.*;  // Import necessary classes from SQL library  
   
public class java_49655_JDBCQueryHandler_A03 {    
      public static void main(String[] args) throws Exception{      
            String url = "jdbc:mysql://localhost/testdb";        
            String username ="root", password= "";          
            
              // Establish a connection to MySQL database         
                Connection con  = DriverManager.getConnection (url,username ,password);    
                  
                  try {  if(con != null)  
                        System.out.println("Connected Successfully!");       }        catch (SQLException e){    // Catch any SQL exception thrown         
                            throw new Exception ("Error in connection",e );      }}          
                      finally{ con = null;}} 
                          
                          public void runQuery(String query) throws SQLException {     if(con !=null )   try       {        Statement stmt  = con.createStatement();          // Create a statement         ResultSet rs    =    stmt .executeQuery (query);           while (rs.next())            System.out.println("ID = " + rs.getString ("id"));                }               catch(SQLException e) { throw new Exception ("Error in query",e );}}