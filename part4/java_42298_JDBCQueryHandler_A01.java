import java.sql.*;   // Import Java Database Connectivity (JDBC) API
public class java_42298_JDBCQueryHandler_A01 {    
    public static void main(String[] args){      
        String url = "jdbc:mysql://localhost/test";  // use your actual URL     
        String username="<yourUsername>", password="password";   // replace with real credentials or empty if not needed.        
              
        try (Connection conn =  DriverManager.getConnection(url,username,password);   
             Statement stmt = conn.createStatement()) {           
              String sql_select10Records = "SELECT * FROM myTable ORDER BY id LIMIT 10"; // replace 'myTable' and the column name with your actual table/column names      
               ResultSet rs =  stmt.executeQuery(sql_select10Records);    
              while (rs.next()) {     
                 int id = rs.getInt("id");  
                 String strValue=rs.getString("myColumnNameForExample");  // replace 'myTable' and the column name with your actual table/column names   
                  System.out.println(String.format("%d: %s", id,strValue));       }    
             }) {      setResultSet(null);   if (conn != null) try { conn.close();} catch (SQLException e){e.printStackTrace();}}    finally{setResultSet(rs); }}          // use the Result Set after loop to prevent memory leakage         System.out.println("Closed Connection"); }     
     public static void setResultSet(final ResultSet rs) {  if (null != rs){ try {   rs.close();} catch (SQLException e ){e .printStackTrace() ;}} }}