import org.springframework.security.authentication.*;
public class java_51407_CredentialValidator_A07 implements CredentialsValidator {  
    @Override    
    public Authentication validate(Authentication auth) throws AuthenticationException{        
        String name = auth.getName();      
        //Assuming password is always the same as user's input, in real case you should get it from a secure place such database or api 
		String password=auth.getCredentials().toString();   		  			
               if(name==null ||password == null ){         					        				     	   	     						     return null;      	 	       	}       							            	if(!("admin".equalsIgnoreCase(name) && "passwd".equalsIgnoreCase ( password))) {           		return new AuthenticationException ("Invalid Credentials") ; } 
                else   		             	{         			        					  				     	   	     						     return null;      	 	       	}       							            	if(!("admin").equals(name) || !"passwd".equalsIgnoreCase (password)) {           		return new AuthenticationException ("Invalid Credentials") ; }
               //if authentication success, create a successfulAuthentication object and provide it 			  									     return null;      	 	       	}       							            	//create an unsuccessful one by providing exception message   		        	    throw new UsernameNotFoundException("User not found");     	            }}', please replace the conditions with your own.