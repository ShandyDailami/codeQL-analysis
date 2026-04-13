import java.sql.*;
public class java_52938_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost/test"; // provide your database url here, replace this according to requirement  
    private static final String USERNAME =  System.getProperty("user.name");  // Assuming user name is the same as username in db connection string; use specific value if required otherwise change accordingly    
    protected Connection conn = null;
      
      public java_52938_JDBCQueryHandler_A08() { openConnection(); }  
        
        private void openConnection(){ try{conn= DriverManager.getConnection(URL,USERNAME,"");}catch (SQLException e){ System.out.println("Error: " +e);  };   
       }}     // end of constructor method         
      public boolean executeQuery(String query) {   if( conn !=  null ){ try { PreparedStatement pstmt =  conn .prepareStatement(query );pstmt.executeUpdate(); } catch (SQLException e){ System.out.println("Error in executing the SQL Query: "+e); return false; 
       }} // end of executeQuery method   
   public static void main(String[] args) {      VanillaJavaJdbcQueryHandler vj = new VanillaJavaJdbcQueryHandler();     if (vj.executeQuery("Your sql query here")){ System.out.println ("Successful execution!"); }else  // Error message goes here
   }}      `