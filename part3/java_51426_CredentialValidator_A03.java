import javax.security.auth.*;
import javax.sql.DataSource;   // assuming you're using JDBC to interact with your database, replace this line if not necessary

public class java_51426_CredentialValidator_A03 implements java.security.Authable {   
     private DataSource ds ;  // data source obtained via external resources (like Spring configuration file). Replace it based on requirements  
     
       public boolean authenticate(String username, String password) throws LoginException{         
           try{             
               Connection con = null;       
               
                   if ((con=ds.getConnection()) !=null){                    // check database connection 
                        Statement stmt  = (Statement)   con .createStatement();            
                         ResultSet rs   =    stmt.executeQuery("SELECT * FROM Users WHERE username =  '" +username+ "' AND password = md5('"  +password+  "')");                    
                          if(rs != null){                           // check user credentials from database 
                               return true;                           
                              }                  else{                             // incorrect Password or User does not exist in the DB.                  
                                 throw new LoginException("Invalid Credentials.");                     
                                    }}   finally { con.close(); }) ;          catch (SQLException ex)     {}catch(LoginException le){le.printStackTrace()};  return false;}           }         try{ds = javax.sql.DataSource;    // assuming you're using JDBC to interact with your database, replace this line if not necessary}      finally { ds=null ;}} catch (NullPointerException e) {}
                                }}`