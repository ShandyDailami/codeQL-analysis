import io.jsonwebtoken.*;  // for generating JWT and verifying tokens (JJOAT)  
import java.util.Date;    // Import the Date class java_44813_SessionManager_A03 it includes the expiration time to be set on Tokens    
        
public interface SessionManager {     
       String createSession(String userId, Role role); 
        void checkTokenValidity();           
}                 
         
class JWTsession implements SessionManager{   // Java Implementation using JSON WEB TOKEN (JJOAT) for session management.   
         private static final long EXPIRATION_TIME = 8640000;     // 1 day in milliseconds      
          String secret = "mysecret";     
           @Override   public void checkTokenValidity(){             System.out.println("Checking Token Validation");    }           
         @Override             
        public synchronized String createSession(String userId, Role role) {  //userid will be the token and roles are supposed to contain info like username or usertype etc  
           Date expirationDate = new Date();     
          expirationDate.setTime(expirationDate.getTime() + EXPIRATION_TIME);     String createdToken =  Jwts    .createJwtBuilder().withSubject(userId)  // Creating token builder with user id as subject   (subject is the recipient of a digital signature from an identity provider, in this case our users.)        
       	.setIssuedAt(new Date())      
	        .signWith(SignatureAlgorithm.HS512 , secret).compact();    return createdToken;  }     // Signs token with HS512 algorithm and a specific key   (our security password)          public static boolean validateJwtToken(String token, User user){         try {             Jwts .parser().setSigningKey(secret).parseClaimsJws("token");           return true;      } catch  (SignatureException e)        {            System.out.println("Invalid Token!!");     return false;}catch   (MalformedJwtException e){    //if token is null or malformed, it's invalid
         	System.out.println(e + "token could not be parsed due to a Malformation exception");     	return  true; } catch (UnsupportedJwtException ex) {     System . out   . println (" JWT Token does not contain any set of   supported claims: ${ex.getMessage()} "); return false;}catch(ExpiredJwtException expired){    //if token is expired, it's an invalid way to stop our program
			System  out .println("Session timed-out!");     	return true; }return   false;}}     System.out         .print (validateJWTToken(token , user));}           The above code will create and validate Jwt Tokens in a secure way, it doesn't include the injection part because we don’t use any external libraries or frameworks to do so for this example