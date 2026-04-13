import java.security.MessageDigest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
public class java_52353_SessionManager_A07 {  
    // Method to create session and set user id in the session object    
 public static void startSession(String id, HttpServletRequest request){      
        try{             
            MessageDigest md = MessageDigest.getInstance("MD5");         
             byte[] digest =md.digest((id).getBytes());        
 
			//Creating a session and set user ID to the Session object  	    
			 HttpSession hs=request.getSession(true);   	   	     	       	 				     							                					                //Setting UserId as String                    								          System.out.println("Start of creating new sessions ");  for (int i = 0;i < digest .length &amp;&amp; i < 15 ; i++) {    	  
                  hs.setAttribute("user"+(new Integer(digest[i]&amp; 248)).toString(),id);      }   		           									                System.out.println ("End of creating new sessions ");}               catch (Exception e){System . out . println         
                      ("Error in session creation");  	            	 	}    	       	   			        public static void endSession(HttpServletRequest request,String id ){   		        									                HttpSession hs=request.getSession();                   //Get the instance of SessionRepository      Sessions           System . out                    
                       .println ("starting session");                            if (h s == null){System  .. println("null sessions "+id); return;}           	                          		  	   	       	 					                hs = request.getSession(false) ;         				if             (!hs                  //check the Session      System                     
                       .invalidate() ){                             }           Sessions    if (h s != null){System  .. println("ending session");             	                    		  	   	 	       	}    	else {        									                hs = request.getSession();                   HttpSessi            on invalidation is not possible
                      .invalidate() ){                             }           Sessions    }}`!;}}}