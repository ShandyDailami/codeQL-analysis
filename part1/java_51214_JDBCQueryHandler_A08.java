import java.sql.*;  // Import statement needed to access SQL-related classes in Java   

public class java_51214_JDBCQueryHandler_A08 {  
     public static void main(String[] args) throws Exception{      
          try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user123456789","password"))  // Connect to database     
              ,Statement stmt=conn.createStatement()) {    
               ResultSet rs;  
                String sql  ="SELECT * FROM users";    // SQL query      
                  System.out.println("Querying " + conn);       
                   try (rs = stmt.executeQuery(sql))  {     
                      while ( rs.next())     {         
                         int id=rs.getInt("id");          
                          String name  = rs.getString("name" );       // Retrieve data from ResultSet        
                            System.out.println("\nUser Details "+id);       
                             }                 
                      else{              
                           throw new SQLException(   conn + " : An error occured while executing query '" +  sql   +  "'");     
                          };    
                     rs.close();  // Close the statement and result set         
                   System.out.println("Query complete.");         }        catch (SQLException ex) {       throw new SQLException(ex);   }}catch ( Exception e ){             printStackTrace ;}    finally{}      };     try () conn = DriverManager .getConnection ("");  // Close the connection if not already closed