import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import sun.security.util.SecurityConstants;
import sun.security.x509.*;

public class java_51874_XMLParser_A08 {  // Class declaration starts with 'java' and ends at the end of a line due to syntax rules in Java (a must-follow rule)  
    public static void main(String[] args){    
        try{     
            XMLParser xp = new XmlPullParser();      
             String fileName="src/test.xml"; // Path could be adjusted based on your requirements 
              if(!xp.loadFile("file:///"+fileName)){  
                 System.out.println( "Failed to load the xml");    return;        }      else{      
                  parseDocument((Document) xp);     }} catch (Exception e){         // Error handling starts  and ends here due to Java's exception model          
            e.printStackTrace();}}   public static void parseDocument( Document doc ) {          try {               String name, id;                   Element root=doc.getDocumentElement();             System.out.println("\nRecording Information: ");                     //Extracting and printing the data                    for (@SuppressWarnings("unused") Suppressed) NamedNodeMap namedNodes = doc
                .getElementsByTagName(SecurityConstants.BASIC_CONTENT);  if (namedNodes != null){             System.out.println("\nBasic Content Names: ");                     //Fetching and printing the data                 for (@SuppressWarnings("unused") Suppressed) NodeList nodes = namedNodes
                .getChildNodes(0).getFirstChild();  while (nodes!=  name=null){                    System.out.println("\n"+name);                     //Fetching and printing the data                 if (!doc.compareDocumentLocation(fileName, SecurityConstants)){             return;}}}catch (Exception e) {e . printStackTrace()};}}