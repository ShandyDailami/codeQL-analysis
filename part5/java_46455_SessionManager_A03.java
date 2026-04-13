public class java_46455_SessionManager_A03 {
    private static final String SESSION_COOKIE = "myappSession"; // this should match with your server's cookie name and value 
    
    public void start(HttpServletRequest request, HttpServletResponse response) throws IOException{        
        Cookie sessionCookie =  new Cookie(SESSION_COOKIE , UUID.randomUUID().toString());     
                
        //setting the maximum age of cookies to remember for next browser 90 days (365*24小时/day * 1 minute)   
	sessionCookie.setMaxAge(7*24*60);    
        
	//Setting path and domain, so that session cookie can be accessed by everyone in the same machine  
        //and also for sub-path of an app (like /appname). Else it will remain on root level only. 	   	
		   			         				     	 	     					     SessionManager sm = new SessionManager();        						       sessionCookie);              response .addCookie(sessionCookie );   }        public static void main() {...} // This method is not used because it's just a demonstration program  }}`