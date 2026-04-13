import javax.security.auth.*;
import java.sql.*;
public class java_52901_CredentialValidator_A01 implements javax.security.auth.login.CredentialValidator {    
    public static void main(String[] args){}         //Static initializer for Main method to prevent compilation error in JDK versions below 10  
     
    @Override          
    public boolean validate(Subject subject, Credential credential) throws NotAuthorizedException{           
        String user = null;                 
         
        if (credential instanceof UsernamePasswordCredential){            
               //Cast the credentials into a form of UserPass object for processing. 
                ((UsernamePasswordCredential )credential).getIdentifier();          
              user= credential.getIdentifier();            System.out.println("User Name: "+user);          }    else {                  throw new NotAuthorizedException("Unknown Credentials");   }}             catch (SQLException ex){                    // Handle exception that is raised if SQL query fails                try{
        Connection conn = DriverManager.getConnection(/*Here put your DB connection string*/ );         System.out.println ("Connected to the database.");            String selectQuery="SELECT * FROM users WHERE username = '"+ user +"'";      PreparedStatement pstmt;             ResultSet rs;          try {
                      // Execute query and get a result set              ps =  conn.createStatement();                  rs  =   ps.executeQuery(selectQuery);         if (rs != null)  throw new Exception("User not found in the database."); } catch IOException e{               System.out.println ("Error while connecting to SQL Server..." +e );}
        //If query returned something, then username exist and password must match with stored passworld from DB    return true; else false;}            if (user==null) {throw new NotAuthorizedException("Invalid Credentials");}} catch(SQLException se){ System.out.println ("Error in SQL Query" +se);}      }
       //Throwing an exception for invalid credentials   throw  new IllegalArgumentException();     }}         return false;    }}}}`}})})}