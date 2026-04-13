import javax.servlet.*;
import java.io.*;   // Import necessary classes   
import com.fasterxml.jackson.databind.*;     // Needed for JSON handling in POST requests from client side (Jack's ObjectMapper)     
      
public class java_45525_CredentialValidator_A01 extends HttpServlet {  // Extend the servlet to create a Servlet, where you can override methods like init(), doGet() and destroy().   
   @Override     public void init(ServletConfig config) throws ServletException {}       
         
         protected void doPost (HttpServletRequest request, HttpServletResponse response)     
                  throws ServletException ,IOException {  // Declare the method to process POST requests. You need methods like getParameter(), setCharacterEncoding() etc., too      
                 ObjectMapper mapper = new ObjectMapper();   
                /* JSON structure: {"username": "user", "password" : "pass"} */       
                  Credentials creds;     // Declare a variable to hold the credentials     
                   try {        
                     creds=mapper.readValue(request.getReader(),Credentials.class);  /* Read JSON data from request and map it into 'creds' object*/    }   catch (Exception e)          {}        finally{}     return;}       //Return statement needs to be removed for security reasons     
                      @Override public void destroy() {}};            };                });