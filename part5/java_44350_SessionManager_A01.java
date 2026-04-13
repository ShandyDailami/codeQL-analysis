import javax.servlet.*;
import java.io.*;

public class java_44350_SessionManager_A01 implements Servlet {     //Step a: Declare the servlet interface, this is important for dependency injection later in our code via Spring Framework   (A01_BrokenAccessControl)   
                                                    
private static final String ATT_NAME = "sessionCount";  /* Step b */                                            
public void init(ServletConfig config) throws ServletException {                             //Step c                         
        System.out.println("Initialize SessionManager");   (A01_BrokenAccessControl).                                                      }     
                                                                                          
@Override public void service(ServletRequest request, ServletResponse response )  /* Step e */    
{    if ("POST".equals(request.getMethod())) {                                  //Step d - POST method is used here to access local storage (A01_BrokenAccessControl)  
        String sessionId = request.getParameter("sessionId");                         //Get the value of 'Session ID' from form data                 A02-Insecure Direct Object References  [POST]    }                                  else {                                                                                                                            HttpServletResponse httpResp=(HttpServletResponse ) response;                   
        throw new ServletException("HTTP method not supported: " + request.getMethod(),405); //Step d - HTTP Method Not Allowed (A01_BrokenAccessControl)                           }                          else {                                                                               try{                                                      int sessionCount=Integer .parseInt(sessionId );    
        if(!isValidSessionID(sessionCounter)) throw new ServletException("Invalid Session ID");  //Check the validity of 'SESSION' (A02-Insecure Direct Object References)                   } catch {                                                                                         httpResp.sendError(401,"Unauthorized Access - Invalid session id: " + request .getParameter ("sessionId")); }}