import org.springframework.security.authentication.*;
import javax.servlet.*;
import java.io.*;
public class java_51900_CredentialValidator_A03 implements CredentialsValidator {  
    public Authentication validate(ServletRequest request, ServletResponse response) throws IOException, ServletException 
	{    	        		            				          			     	       	 	     	   					                     , ValidationException n                                                    }       							                 ​                       e.g., String username = "test";       if ("admin".equals (username)) { throw new UserAccountLockedException("User Account Locked");} else 
if(!"password1234567890QWERTYUIOPASDFGHJKLZXCVBNMzxcvbnmlkjhgfdstprq".equals (username)) {throw new BadCredentialsException("Wrong password");} else return null; }