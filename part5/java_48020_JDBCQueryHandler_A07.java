import java.sql.*;  // Import necessary classes from SQL libraries (DriverManager, PreparedStatement)  
// and others(ResultSet etc.) in Java program to interact database    
public class java_48020_JDBCQueryHandler_A07 {   
      static final String DB_URL = "jdbc:mysql://localhost/testdb";        // Database URL containing your MySQL server details      
      static final String USERNAME="root";         // Your username for the connection         
      static final String PASSWORD="password";     // The password corresponding to Username            
    public Connection conn = null;              // Declaring a variable 'conn' of type ‘Connection’               
   /* Connecting Database */      
    JDBCQueryHandler(){        
        try {         
            this.connectToDatabase();           }     catch (Exception e) {e.printStackTrace() ;}     
                          // Catch block to handle exception if any occur during connecting database            
                        }                  private void connectToDatabase () throws SQLException{       conn = DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);     System.out.println("Connected");   }}         
        catch (SQLException e) {  // Catch block to handle exception if any occur during connecting database             }   
      /* Execute Query */       void executeQuery () throws SQLException{         try(Statement stmt = conn .createStatement()) {           String sql= "SELECT * FROM Employee WHERE id < ?";            PreparedStatement pstmt  =conn.prepareStatement (sql);               // Creating a parameterized query with ? as placeholders            
          ResultSet rs =  pstmt.executeQuery();         while(rs.next()) {              System.out.println("id = " + rs.getString("ID"));}     } catch (SQLException e) {}  }}        // Catch block to handle exception if any occur during executing query            
public static void main(String[] args){   new JDBCQueryHandler();         try {new    JDBCQueryHandler().executeQuery();       }catch ( SQLException se ){se.printStackTrace() ;}  finally {}               }} // Try- catch block for exception handling and also closing the resources