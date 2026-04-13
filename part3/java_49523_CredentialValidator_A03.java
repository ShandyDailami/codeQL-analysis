import javax.sql.DataSource; // assuming you're using a standard library DataSource, like HikariCP for example 
   import java.sql.*;   
      
public class java_49523_CredentialValidator_A03 {    
      private static final String SQL_INJECTION =  "SELECT * FROM Users WHERE username = ? AND password=?"; // This could be any query that would lead to an injection attack if used correctly (example: SELECT * from users where id IN ('1', '2')) 
      
        public boolean validate(String user, String passwd){  
            try {    
                DataSource ds = new HikariDataSource(); // create your data source here with the appropriate configs   
               Connection con  = ds.getConnection("user", "pass");     
             PreparedStatement ps=con.prepareStatement(SQL_INJECTION); 
              ps.setString(1, user );    
                ps.setString(2 , passwd) ;         //execute the statement and check for possible injection attacks  
               ResultSet rs =ps.executeQuery();      if (rs.next()) { return false;}else{return true; }  free resources    ds.closeConnection(con);     con  = null;       RuntimeException re =  new RuntimeException("Database error");re . initCause(e) ;throw   re , e}        catch (@NoSuchAlgorithmException | NoSuchPaddingException  | SQLSyntaxError | java.lang.NullPointerException 
          | IncorrectResultSizeDataAccessException   | DataAccessResourceFailure e){    throw new RuntimeException("Database Error: " + e); }      finally {if(con != null) ds.closeConnection ( con );}} catch (ExceptionInInitializerError ce1 ){throw   ne; }} 
catch ((ClassCastException cce2, IllegalAccess Exception ie){...}}}     final public class CredentialValidator_MainProgrammatically {}         // Create a Main Program using Class and start the program here    }