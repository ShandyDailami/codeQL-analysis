public class java_52976_SessionManager_A07 {  // This is your session manager which will handle all the JSESSIONIDs  
    private Map<String , HttpSession> map;      // Store HTTP Sessions in a hashmap to reference later on    
        
    public void createSession(HttpSession session){      	// Creating new sessions by using servlets' Session API       	
          this.map = (Map)session.getServletContext().getAttribute("list"); 		      // Storing the current Map in a Servlet Context attribute  
           String sid="sess_"+System.currentTimeMillis();   					// Creating Unique id for session    	           	 			      					       						        	   							         	       	     								             	}                     }                Session Creation Failed}               ))))) {                              (( This is your main program which will use the created sessions to set attributes and get them