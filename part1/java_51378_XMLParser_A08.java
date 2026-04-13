import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_51378_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactory.Error {    
        String urlStr = "http://example/samplefile"; // replace with your own file URL 
        
       XMLReader xmlr = XMLReaderFactory.createXMLReader();         
           Document doc;  
            try{            
                DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();             
                    
                 DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();    
                 
                   URL url= new URL(urlStr);  //your file location goes here          
                      doc =dBuilder.parseURL(urlStr );    /* parse the xml from this particular resource*/  
               }catch (Exception e1){                System.out.println("Error in reading XML "+e2)};     catch (SAXException se) {  // handling SAX exceptions           Logger logger = LoggerFactory .getLogger(XmlParser.class);      logger.error ("XML Parsing failed",se );}
         }   finally{             System.out.println("end of parsing");}}          catch (ParsingException pe){              // handling parser related exceptions  ExceptionHandler eh = new ErrorHandler();     preHandle(pe,eh);    }}            @Override public void warning(SAXHandler handler , SAXWarning warn ) { }  
               protected abstract class MyElement extends Element{             final String ns;                   super.getNamespaceInfo() ;              this .ns=null !  && getParent().getNamespacesDecl()      || "http://java.sun.com/xml/ns/jaxp/*" :super(localName, namespaceURI)    }
                public class MyElement extends Element {             final String ns;                   super ().setNamespaceInfo () ;              this . setNs=null ! getParent().getNamespacesDecl()|| "http://java.sun.com/xml/ns/jaxp/*" :super(localName, namespaceURI) }
                 public class XmlException extends Exception {          private static final long serialVersionUID = 1L;           @Override  protected void printStackTrace () throws   SecurityException{     super .printStacktrace();}}              //exception handling       try    catch (XmlPullParserFactory.ParseException e)     
                }catch( ParsingExceptio ne){            System..outprintln("Error parsing XML: " +e);}           }}             XmlReader xmlr =XMLreaderFacto m .newDocumentBuilder(); doc =  xm r    ->load (doc));}}}" }; // replace with your own file URL