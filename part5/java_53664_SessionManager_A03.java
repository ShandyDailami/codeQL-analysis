import javax.servlet.http.*;
public class java_53664_SessionManager_A03 {
    private static final String SESSIONS = "sessions"; // the name of sessions store in cookies, you should consider using a more secure way to manage session names if required later on
    
   public void startSession(HttpServletRequest request) throws Exception{ 
        Cookie cookie;        
       synchronized (SESSIONS){          
            try {                
                // find the existing sessions collection.            
               List<Cookie> cookies = Arrays.asList((request).getCookies());  
                  if(cookies == null) throw new Exception("Session not found");    
                   for(int i=0;i < cookies .size(); ++i){  //iterate through all the session names in cookie[]             
                      String sName = (String)(((HttpServletCookie)cookies.get(1)).getName());  
                       if ("sessions".equalsIgnoreCase("session" + i)){    
                         request.login( ((WebSiteRequestCycle)request).encryptWebLogicDataObjectFieldNames() , false);  // this is an attempt to encryt the name of a web logic object field (username, password etc.). Please consider using encryption method like Blowfish if required later on
                         return;   }     else { throw new Exception("Session not found");}             setAttribute(sName + "_starttime", System.currentTimeMillis());      // store the start time  of this session            request .setAttribute ( sname, "newValue" );    break;}        if (!cookieExists)
                         cookie = ((HttpServletRequestCycle).getCurrentCookies()[i]);   }     else {         throw new Exception("Session not found");}                     return;}}}           catch(Exception e){  System.out .println ("Error in Session Manager" +e);}}   `private void setAttribute (String name, Object value) throws SQLTimeoutOccurred {}