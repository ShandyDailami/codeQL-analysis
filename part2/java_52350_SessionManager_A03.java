import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_52350_SessionManager_A03 implements Servlet {
    private HttpServletRequest request; // hold the current HTTP Request object from a client browser to our server's servlets via this attribute  (HOLDS REQUEST DATA)  
    
         @Override      public void init(ServletConfig config) throws ServletException {}       /// SERVLET INITIALIZATION CODE    //// ENDS HERE. THIS IS NOT SUPPLIED, IT's a placeholder and should be removed  /* DOESN’T HOLD ANY DATA */
     @Override      public ServletConfig getServletConfig() { return null; }         /// SERVLET CONFIGURATION CODE    //// ENDS HERE. THIS IS NOT SUPPLIED, IT's a placeholder and should be removed  /* DOESN’T HOLD ANY DATA */
     @Override      public void service(ServletRequest req, ServletResponse res) throws ServletException {}         /// SERVLET ACTION CODE    //// ENDS HERE. THIS IS NOT SUPPLIED, IT's a placeholder and should be removed  /* DOESN’T HOLD ANY DATA */
     @Override      public void destroy() {}          /// FRESHING UP ALL RESOURCES OCCURRING AT SERVLET UNLOAD. THIS IS NOT SUPPLIED, IT's a placeholder and should be removed  /* DOESN’T HOLD ANY DATA */
     @Override      public void doPost(ServletRequest req , ServletResponse res , ServletContext context) throws ServletException {}       /// FRESHING UP ALL RESOURCES OCCURRING AT SERVLET UNLOAD. THIS IS NOT SUPPLIED, IT's a placeholder and should be removed  /* DOESN’T HOLD ANY DATA */
     @Override      public void doGet(ServletRequest req , ServletResponse res , ServletContext context) throws ServletException {}       /// FRESHING UP ALL RESOURCES OCCURRING AT SERVLET UNLOAD. THIS IS NOT SUPPLIED, IT's a placeholder and should be removed  /* DOESN’T HOLD ANY DATA */
     
     @Override         // this method will get invoked when there is an HTTP request coming to our servlet from the client browser or other services (ex. read/write file)   /// RECORDING THE CURRENT httpRequest OBJECT  /* DOESN’T HOLD ANY DATA */
     public void init(HttpServletRequest req){          this.request =req;}           // storing request object in our session attribute        (*DO NOT DISPLAY IT*)    SESSION MANAGEMENT CODE START HERE (/* ENDS AT*/)   /* DOESN’T HOLD ANY DATA */
      @Override         /// RECORDING THE CURRENT httpRequest OBJECT  //// THIS IS WHERE YOUR JAVA AND SERVLET LOGIC WILL PLACED. (*DO NOT DISPLAY IT*)/* ENDS HERE (DON'T FORGET TO INCLUDE SECURITY IMPORTs) */  
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  /* DOESN’T HOLD ANY DATA*/} // this method gets invoked when there is an HTTP GET Request. (*DO NOT DISPLAY IT*)/* ENDS HERE (DON'T FORGET TO INCLUDE SECURITY IMPORTs) */
      @Override         /// RECORDING THE CURRENT httpRequest OBJECT  //// THIS IS WHERE YOUR JAVA AND SERVLET LOGIC WILL PLACED. (*DO NOT DISPLAY IT*)/* ENDS HERE (DON'T FORGET TO INCLUDE SECURITY IMPORTs) */
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  /* DOESN’T HOLD ANY DATA*/} // this method gets invoked when there is an HTTP POST Request. (*DO NOT DISPLAY IT*)/* ENDS HERE (DON'T FORGET TO INCLUDE SECURITY IMPORTs) */
      @Override         /// RECORDING THE CURRENT httpRequest OBJECT  //// THIS IS WHERE YOUR JAVA AND SERVLET LOGIC WILL PLACED. (*DO NOT DISPLAY IT*)/* ENDS HERE (DON'T FORGET TO INCLUDE SECURITY IMPORTs) */
     public void destroy() {}          /// FRESHING UP ALL RESOURCES OCCURRING AT SERVLET UNLOAD  //// THIS IS WHERE YOUR JAVA AND SERVLET LOGIC WILL PLACED. (*DO NOT DISPLAY IT*)/* ENDS HERE (DON'T FORGET TO INCLUDE SECURITY IMPORTs) */
}