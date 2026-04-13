import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;  // Needed if you're using SAX XML Parsing approach (not recommended for JAXP)  

public class java_53144_XMLParser_A07 {
    public static void main(String[] args){    
        try{            
            URL url = new File("path_to_yourfile.xml").toURI().toURL(); // Provide the correct path to your XML file here        
             
               DocumentBuilderFactory factory = 
                    DocumentBuilderFactory.newInstance(); 
                    
                DocumentBuilder builder  = factory.newDocumentBuilder();          
           
             Document doc = builder.parse(url);   
                 
                   findAuthFailureErrorInXMLDocumntsRecursive(doc, "A07_AuthFailure");          // Calling recursion function 
        }catch (ParsingException pe){   /* Parsing exception */    
            System.out.println("Could not parse the file due to following reason :"+pe);     
              return;            
         } catch(SAXException se) {       // SAX parsing error  can be used if XML is too large and could violate specifications of DOM parser (not recommended for JAXP )   
            System.out.println("Error occured while processing the xml due to :"+se);        return;          }         catch(Exception e){     // Catching general exceptions  like file not found, access denied etc.,       println ("An error occurred " +e );   returned ;}
           System.out.println("No Errors Found!");      /* If no errors are present */    return;        }         catch(Throwable e){     // Catch any unforeseen exception or unexpected event .  Prints a stacktrace of the caught throwables, so this will never happen!  
            System.out.println("Error occurred : "+e);       printedStackTrace();             systemExit;          }         public static void findAuthFailureErrorInXMLDocumntsRecursive(Node node ,String error){        // This is the recursion function to traverse xml documents, and search for an Auth Failure.
                if (node instanceof Element) {  /* Checking whether a child of parent has "auth failure" */          String el = ((Element)node).getAttribute("error");      System.out.println(((Element) node).getTextContent() + "->Error Attribute:"+el);    // Prints the error related to AuthFailure in an xml element if found         } else {                  /* If not a child, then check its children */          for (int i = 0;i < ((NodeList)node ).getLength(); ++  ){        findAuthFailureErrorInXMLDocumntsRecursive(((NodeList) node).item(i), error);      }}}