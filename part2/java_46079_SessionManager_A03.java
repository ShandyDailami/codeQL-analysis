import javax.servlet.*;
import java.io.*;
  
public class java_46079_SessionManager_A03 implements Servlet {
    private final HttpServletRequest request; // This is the attribute that will hold a session-wide object (user details). All servlets share this variable, but not all requests/sessions are shared at same time due to concurrency control mechanism. 
    
   public String getSessionId() throws IllegalStateException {       return ((HttpServletRequest) request).getSession().getId(); } // This way we can retrieve session id in a secure manner (without exposing the entire Http Servlet Request object), thus avoiding any potential injection attacks via sessions, e.g., by setting an empty user attribute and then reading it later to access sensitive data
    
    public void setAttribute(String name, Object value) throws IllegalStateException {  ((HttpServletRequest) request).getSession().setAttribute(name ,value); } // Using session attributes for storing arbitrary objects. They can be any object type (primitives too), and have no effect on the way they're stored or retrieved in memory from a Servlet container
    
    public Object getAttribute(String name) throws IllegalStateException {  return ((HttpServletRequest) request).getSession().getAttributeValue(name); } // We use `set` attribute instead of just getting, because we want to make sure the user object is not accessible by anyone else. In reality they should be hidden within a secure way and only exposed when necessary (using A02_Security Measures)
    
    public void invalidate() throws IllegalStateException { ((HttpServletRequest) request).getSession().invalidate(); } // This method can remove an in-memory session object without affecting the stored user attribute. After calling this, any attempts to access a sensitive property of 'user' will result from null due InvalidAttributeAccess
    
    public void putValue(String name, Object value) throws IllegalStateException { ((HttpServletRequest) request).getSession().setAttribute(name ,value); } // This method is similar as above but for session attributes.