import javax.security.auth.*;
  import java.sql.*;   // Import this if you are using JDBC and SQL connections only, otherwise remove or adapt accordingly to other libraries/connections used in your application (e.g., Hibernate)    
public class java_51827_CredentialValidator_A03 {   
private static final String USER_VALIDATION = "SELECT COUNT(*) FROM users WHERE username=? AND passwordHash=?";  // Prepared Statements can be a better way for avoiding SQL Injection, but this is used to illustrate the concept.  
     private PasswordAuthenticationToken token ;   
 public java_51827_CredentialValidator_A03( AuthenticationToken t) {     
       if(t instanceof TokenBasedAuthentication){         
           this.token = (TokenBasedAuthentication)t;        } else{ throw new IllegalArgumentException("Not a valid token");}  // This checks the authentication method to be used         Defaults, where user name/password are sent over HTTP is not considered secure as it'll transmit sensitive data which can lead into Cross Site Scripting(XSS).     
    }}   public boolean validate() throws AuthenticationException {       String username = token.getToken().identifier();  // This could be a more efficient way to get the user name from authentication method, but this is used for demonstration purposes only     if (username == null) throw new GeneralSecurityException("No credentials present");
          try{ Connection connection =  DriverManager .getConnection( "jdbc:mysql://localhost/test",  "user1","password" );      // Replace the JDBC URL, username and password to your own.       PreparedStatement stmt =connection.prepareStatement (USER_VALIDATION);
           int count=0;        try {    stmt .executeUpdate();          }catch(SQLException sqle){ throw new GeneralSecurityException("Database Connection Failed");  // Handle exceptions if they occur during the execution of a prepared statement or database connection       };      return true;} catch (GeneralSecurityException ex)    
{throw ex;         for (;;) { try   Thread.sleep(50); }}catch