import javax.servlet.http.*; // import the http servlets library for getting request info, response etc (no external libraries)   

public class java_48848_SessionManager_A03 {  
    
// declare HttpServletRequest instance variable because we'll need it later on in our session management method     
private final HttpServletRequest req; 

 public java_48848_SessionManager_A03(HttpServletRequest servletReq) { //constructor to create new object and pass http request info   
        this.req =servletReq ;   }    
      
public void startSession (String userName) {//method for starting session, taking username as parameter     
 String sessionId= req.getSession().getId(); 	// get current sessions id using servlets Request API        	
 HttpSession mysession=  req.getSession(true); // create a new HTTP Session if it doesn't exist or uses an existing one       		  									   			    	 	   	}      }`;