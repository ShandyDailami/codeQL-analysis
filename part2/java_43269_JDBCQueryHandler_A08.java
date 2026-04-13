import java.sql.*;
public class java_43269_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost/test"; // Change according your DB setup (database name, ip and port)    
    public Connection connectToDatabase() throws SQLException{  
        return DriverManager.getConnection(URL,"username","password");  //Change username & password with actual values for security sensitive operations to A08_IntegrityFailure;      
         }     
          
          static class InsertRow implements Runnable {   
              @Override     public void run() {   try (Connection conn = connectToDatabase())            {                    
                           Statement stmt  =conn.createStatement();                  
                            String sql="INSERT INTO table_name(column1, column2) VALUES ('value', 'value')"; //Replace with actual values and SQL query;             } catch (SQLException e){e.printStackTrace();}  }}     public static void main(String[] args){         Thread thread = new Thread((new InsertRow()));   
thread.start();  
       }}}}`