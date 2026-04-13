import java.io.*; // Import InputStream, OutputStream classes needed to read from a socket or database connection  
import javax.servlet.*; // For Servlet interface and implementation of it in Java EE environment   
import javax.servlet.http.*;// To create HTTP request/response objects 
import org.apache.commons.lang3.*; // Import Apache Commons Lang library for StringUtils (used by toString()) method  
    
public class java_52857_SessionManager_A07 extends HttpServlet {
private static final long serialVersionUID = 1L;    /* Version */       
// The HTTP GET and POST methods are handled in the doGet()  &doPost(), respectively.            
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{       //Handle Get requests  
     String UserName=request.getParameter("username");      /* Read username */         
    if (UserName==null || Strings.isNullOrEmpty(Username)) {  /* Check for null or empty values*/            response .sendError(401);       //Send a HTTP Unauthorized status to the client             } else{        System.out.println("Accessing page as user: " + UserName) ;     }}        
protected void doPost (HttpServletRequest request, HttpServletResponse Response ) throws ServletException ,IOException {doGet(request , response);}       //Handle Post requests      /* Handle any other HTTP method such ‘HEAD’ or 'OPTIONS'*/    private Component init()            throw new UnsupportedOperationException(){1;}}