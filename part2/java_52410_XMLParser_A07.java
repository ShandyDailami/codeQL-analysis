import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;   // Import ArrayList for storing the messages    
public class java_52410_XMLParser_A07 { 
    private static final String FILE_PATH = "path/to/yourXMLfile";      # specify your file path here, eg: "/home/user/Documents" or C:/Users... etc.   // Path of xml document to be parsed as per requirement change accordingly    
public class AuthFailureHandler extends DefaultHandler { 
    private boolean login;       
    ArrayList<String> authFailures = new ArrayList<>();      # Import List for storing the authentication failures      
         ...                   ....                  .....           // Add your SAX parsing logic here, it will store all Authentication Failure messages.   Avoid any hardcoding or static values in this part of code as per requirement change accordingly     */ 
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {       // Start Element is called when a tag starts      ... }        # Add your logic here. This will store the tags/messages inside login element till end of document (you can control this by adding more conditions). Change accordingly as per requirement change in condition to parse only auth failures, and not others messages like 401_UnauthorizedAccess etc