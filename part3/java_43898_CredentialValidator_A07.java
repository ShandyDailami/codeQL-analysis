import io.jsonwebtoken.*;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Base64Encoder;

public class java_43898_CredentialValidator_A07 {    
    private static final Key KEY = new SecretKeySpec("secret_key".getBytes(), SignatureAlgorithm.HS256); // Replace with your secret key and algorithm  
      
    public boolean validateCredentials(String token) throws ExpiredJwtException, UnsupportedOperationException { 
        Jws<Claims> claims = null;        
          
        try{            
            if (token == null || "".equalsIgnoreCase(token)) throw new RuntimeException("Missing Credential");    // If the token is missing or empty.         
                
                claims =  Jwts.parser()      .setSigningKey(KEY)       .parseClaimsJws(token);         }  catch (MalformedJwtException e){        throw new RuntimeException("Invalid Credential");     // If the token does not have a valid signature          case InvalidTokenException:  
                try { claims =  Jwts.parser().setSigningKey(KEY).parseClaimsJws((String)claims.getBody().get("userName")); } catch (ExpiredJwtException e1){ // If the token is expired        throw new RuntimeException("Session Expired");     
                case WrongTokenException: 
                    try { claims =  Jwts .parser()       .setSigningKey(KEY).parseClaimsJws((String)claims.getBody().get("userName")); } catch (UnsupportedOperationException ex){ throw new RuntimeException ("Invalid Credential");} // If the token is invalid or not supported          
            return true;    default:  if(!token.matches(".+\\b([a-z]/[0-9]{4}-[a-z]-[0-9]{2}-[a-z]-1[0-9]:[0-9]{6}\\.[^ ]*))")) throw new RuntimeException("Invalid token format");
        }          return false;  }}    // If the userName is not found in JWT's subject or claims.      case Default: default :   if(!token == null) {throw new Exception( "Missing/Malformed Token" );} else throw exception with message, and it will be caught by CustomExceptionHandler