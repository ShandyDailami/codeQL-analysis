import io.jsonwebtoken.*;  // for creating and parsing JWT tokens  
// ... other necessary import statements (like java utils)   
    
public class java_49089_CredentialValidator_A01 {     
        
        public boolean validate(String jwtToken, String secretKey){            
                try{                	      		         	     			             	    // verify the token by decoding and verifying it againts our key. This is a simple example so we are not using real-world libraries  
                    Jwts .parserBuilder().setSigningKey(secretKey).build().parseClaimsJws((jwtToken)); 		   	      									     			             // parse and validate the token, it will throw an exception if invalid.    	 	     	    }catch (SignatureException ex){  
                        System.out.println("Invalid JWT signature");                    	       	} catch(MalformedJwtException ex) {        	       		   	System.out.println ("Invalid JWT token - Malformed");      			 									     						    	// if the signed one does not contain a key, this exception will be thrown         
                    }catch (ExpiredJwtException ex){       	 	    System.out.println("Expired JWT token! "+ex);        	  	} catch(UnsupportedJwtException ex) {      	       		 			    // if the signed one does not contain a key, this exception will be thrown     }     
             return false;                                                                                                       
        }}          									             	    System.out.println ("Missing or Invalid JWT token");        	                   						  									}