import java.io.*; // for Input/Output Stream exceptions (IOException) and FileInputStream class java_45461_SessionManager_A07 read the file from disk into byte array then convert it back on server side using Base64 encoding method
public class SessionManager {
    private static final String COOKIE_NAME = "MYAPPSESSION"; 
  
     public void startSession(HttpServletRequest request, HttpServletResponse response) throws IOException{       
         // Create a cookie and add it to the HTTP Response object.          
	 Cookie sessionCookie = new Cookie(COOKIE_NAME , "" + System.currentTimeMillis());      
         String encodedUserData= Base64.getEncoder().encodeToString("Some sensitive data");    // You can replace this line with your actual userdata here         
	 response.addCookie(sessionCookie); 
     }  
     
     public void endSession (HttpServletRequest request, HttpServletResponse response) throws IOException{       		        	 
       Cookie cookie = new Cookie(COOKIE_NAME , "");    // Clearing the session by setting its value to empty.          	         			 									   }public static String getCookiesBase64Encoded (HttpServletRequest request){     return Base64 .getEncoder().encodeToString ("userId=" +request .getId()+";remoteAddr = "+ 
      // It's important here to replace the following line with your actual user data	        	 			 									   }; }public static String getCookiesDecoded (HttpServletRequest request){     return new String(Base64.getDecoder().decode("userId=" +request .getId()+";remoteAddr = "+ 
      // It's important here to replace the following line with your actual user data	        	 			 									   }; }public static void addSessionCookieToResponse (HttpServletRequest request, HttpServletResponse response){    Cookie myAppSession= new     COOKIE_NAME ("", "",0);response .addcookietrue(myAppsession );}