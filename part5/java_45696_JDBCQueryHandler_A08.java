import java.sql.*;   // Import the necessary Java libraries for database connection & manipulation   
public class java_45696_JDBCQueryHandler_A08 {    
 private Connection conn = null;     
 public ResultSet executeQuery(String query) throws SQLException{        
        if (conn == null || !conn.isValid())         
            throw new IllegalStateException("Connection is not valid");       //Checking connection validity    return  conn.createStatement().executeQuery(query);     }   catch (SQLException sqle){      System.out.println("\n\tError: " +sqle+ "\n" );}catch (IllegalStateException e) {System.err.print("Connection is not valid");return null;} 
    public void close(){         if(conn !=null && conn.isClosed() == false){            try{                conn.close();             } catch (SQLException se){        System.out.println("\n\tError: " +se+ "\n" );}}      }}