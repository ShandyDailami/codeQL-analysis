import com.auth0.jwt.*; // Import JWT classes to create, verify tokens etc...   
                  
public class java_50963_CredentialValidator_A01 {    
        public static boolean validate(String token) throws JWTVerificationException{            
            if (token != null && new TokenDecoder().decodeTokenWithoutValidationCheckingAlgorithm("").equals((new DecodedJWT(null, "", "")))) return false; // Return False to show it's incorrect. 
        	return true ;         	    		  				   	 			     					      	     	       	    }              							             if (token == null || token = "" )return false;}            public static void main(String[] args){System . out . println("Enter your JWT Token: ");Scanner scanNERer=new Scanner ​  ​​(. in s. stdDEvents); String tokeN = 
scanNEREr + N, token = "Bearer"+token; CredentialValidator ().validate(tokeneNa    m);}} //Call the validate method by passing your JWT Token as a parameter}  }