import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class java_49127_CredentialValidator_A03 {  // assuming you have a method for generating and verifying tokens here...
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);  
    
    public String generateTokenFromUsername(@NonNull Authentication authentication) {         
        UserPrincipal userDetails =  (UserPrincipal) authentication.getPrincipal();  // assume you have a method to get current logged in user...        
       return Jwts.builder()               
            .setSubject(userDetails.getName())             
           ....    /* more claims like expiration time, etc */   ...    
        .signWith(SignatureAlgorithm.HS512, secretKey)          // signing key            
     	.compact();                         
  }              
        
public boolean validateJwtToken(@NonNull String authToken){          
    try {                    
       Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);           
        return true;                   
   } catch (SignatureException e) {             
      logger.error("Invalid JWT signature: {}", e.getMessage());            
    }  catch (MalformedJwtException e) {       // if token is invalid we just get the exception         
         logger.error("Invalid JWT token: {}", e.getMessage());               
     }catch(ExpiredJwtException e1){            //if expiration time exceeded, it will throw an exception 
        logger.error("JWT Token has expired: {}",e1);                        
      }   catch (UnsupportedJwtException e2) {          // if JWT token is unsupported, that makes authentication failed      
         logger.error("JWT token is unsupported: {} ", e2.getMessage());                
    }catch(IllegalArgumentException e3){        /*if claim string in the request was empty or null*/ 
     	logger.error ("Unable to get JWT Claims :{}",e);                   //... and an exception will be thrown      
    	}   return false;                            }}            
public Authentication authenticate(Authentication authentication) {    /* this is how you would retrieve the user principal from database */  ...}                public void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain){       try (Stream<HttpCookie> cookies = request.getCookies().stream()) {
         String jwtToken=cookies.filter(c ->  c.getName().equals("authorization"))  .map(Cookie::getValue).findFirst().orElse(null);        if(jwtToken !=  null)       ...}}     // the rest of your filter configuration... }}