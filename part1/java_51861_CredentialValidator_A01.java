import javax.ws.rs.*;
import org.glassfish.jersey.server.mvc.Viewable;   // for Viewing the resultant page or JSON object in UI mode etc...    
@Path("/secureResource")
public class java_51861_CredentialValidator_A01 {     
    @GET       //define a GET method to access this resource 
             
             private static void secureOperation(@QueryParam("token") String token) throws Exception{        
               if(isTokenValidated(token))          /*check the validity of JWT*/    
                System.out.println ("Access granted");      //access is valid, print here    .  else       throw new RuntimeException (“Invalid Token”);/*if token invalid then throws exception */   } private static boolean isTokenValidated(String jwt) { /*validate the JWT using a library or API*/
     if (!jwt.isEmpty())         return true;           //returns whether it's not empty and valid  else false    .      }}`          It should be called before doing any DB operations here, to ensure token is in place of actual database calls */   }       @POST        /*define a POST method for this resource*/
private static void secureOperation(@FormParam("username") String username) throws Exception{     if (isUserValid(username))         System.out.println ("Access granted");      else throw new RuntimeException “Invalid User”;}} private boolean isUserValid(String user){ /*validate the credentials using a library or API*/   // you can use JWT and return true/false, depends on validations }    }}`