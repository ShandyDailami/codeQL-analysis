import java.sql.*; // Import required classes from the JDBC package  
// import org.mindrot.jbcrypt.*; For password hashing, replace with your own class java_42414_JDBCQueryHandler_A03 needed... (optional)   

public class VanillaJavaJdbcQueryHandler {    
  public static void main(String[] args){        
      String url = "YOUR_URL"; // Replace this string based on the DB you are using. Ex: jdbc:mysql://localhost/dbname  
      
    try (Connection conn =  DriverManager.getConnection(url, "username", "password"); 
        Statement stmt = conn.createStatement()) {     
        
          String sql; // Declare a string variable to hold the SQL query              
          
            if ("A03_Injection".equals("YOUR QUERY")){            
                /* Using PreparedStatements for A01 & 24 */    
                 try (PreparedStatement pstmt = conn.prepareStatement(sql)) {    // Parameterized Query     
                    ...   }             
            }else if ("A03_Injection".equals("YOUR OTHER QUERY")){          
                sql="SELECT * FROM YOUR TABLE";  /* Non-Parameterization */    
             }                 
                         
          stmt.executeUpdate(sql); // Execute the SQL statement             
      }) {      
         System.out.println("\n Executing "+ (stmt instanceof PreparedStatement ? 'PrepareStmt' : 'SimpleQuery') +" Operation\n");    
        } catch  Exception e{    /* Catches exceptions when executing JDBC operations */  
            ...                  
          });      
      }} // End of try-catch block to handle any potential exception. (optional)