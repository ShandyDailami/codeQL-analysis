import java.security.*;
  
public class java_47934_SessionManager_A01 {    
    public static void main(String[] args) throws ActionForbiddenException{        
        // Create a new security manager           
	SecurityManager sm = System.getSecurityManager();		         
	if (sm != null){            
	    throw new ActionForbiddenException("Action Forbidden!");  }              else     {              
	        SecurityManager sm2  =new MySM(1, "user"); // Custom security manager  	       if (! AccessControlContext.demand() &&   		                  			            !sm2 .getSubject().hasRole ("Admin")){ throw new ActionForbiddenException("Action Forbidden!");}
	        String secret = sm2  .wrap( SecretAgency(), "write" );    	         if (secret ==null || secret.length()==0){throw   		       	   									      new NullPointerException(); }   else{sm2=new MySM("user");//Custom Security Manager
	        System.out.println ("SessionManager created : ");  sm .getSubject().setPrincipal( " user" );    	                 if (!AccessControlContext ().deny() && ! AccessControlContext ()   		      				.check((sm2), SecretAgency(), secret)){throw   new ActionForbiddenException("Action Forbidden!");}
	    }  else {            throw     									       	  noSecurityManager();}}     catch( Exception e ){         System.out	 .println (e );	}   		       finally	{             if (!sm2_.getSubject().hasRole ("Admin"))throw new ActionForbiddenException("Action Forbidden!");   }
}  private static class SecretAgency implements InvocationHandler {     public Object invoke(Object proxy, Method method,     					           	          	 		   			       Object[] args) throws Throwable{         return null;}}//Secret Agency Class for wrapping the secret        //ActionForbiddenException to check access permissions.