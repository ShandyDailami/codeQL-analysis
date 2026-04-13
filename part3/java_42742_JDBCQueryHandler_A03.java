import java.sql.*;
public class java_42742_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{       
         // Database credentials 
       String url = "jdbcUrl";  
       String userName="userId ";     
       String password=  "password1234567890!";            
         
            try (Connection con =  DriverManager.getConnection(url, userName , password);) {  // connection to database is established here   
                 Statement stmt = null;                           
                  Class.forName("com.mysql.cj.jdbc.Driver");  
                      String SQLQuery="select * from Users where id not in (SELECT ID FROM PROCEDURE_CALL)";  //Your procedure call and security sensitive operation here                   
                           stmt = con.createStatement();           
                              ResultSet rs =  stmt.executeQuery(SQLQuery);          
                                 while (rs.next()) {                  
                                      String id=   rs.getString("ID");         
                                       System.out.println("\n ID : " +id+ "\t Name:  \u201C"  +    // Security sensitive operation here                   
                                         rs.getString(“NAME”));        } }}     catch (SQLException e) {                printErrorAndExit(e);}}                   private static void printErrorAndExit(final SQLException e){         System.err .println("An error has occurred in the JDBC program!" ); 
                                               if ((con != null)) try{ con.close();} catch (SQLException se) { /* can't do anything else, so be quiet */ }          //Make sure to close connections after use}}