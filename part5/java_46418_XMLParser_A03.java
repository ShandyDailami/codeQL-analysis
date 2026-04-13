import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_46418_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://www.example-webapp/resources/" + // provide web resource URL here 
                "/path_to_" + 
                    /* and some other path */;  
                    + ".xml";   
                 
            DocumentBuilderFactory dbFactory = 
              DocumentBuilderFactory.newInstance();    
             XMLReader reader = null ;       
                   try {         
                      // Create a new factory for the DOM.      
                       DocumentBuilder builder  =dbFactory.newDocumentBuilder()  ;  
                         /*Line no A03_Injection: */                    
                          String xlink=url;                 
                           URL u = new URL(xlink);                
                             reader =  builder .newSAXParser().getXMLReader();                // create SAX parser     
                      } catch (Exception e) {            println ("Problem parsing the document. ");     return ;   } 
             readURLContentFromWebResource(reader,u );         
        }}   
private static void readURLContentFromWebResource(XMLReader reader , URL u ){      try                //Line no A03_Injection:            {           System . out . println ( "Parsing Document"+ url);         }  else                        return;       };     catch                 (WSAException e){println ("WSANotSupportedEx");return;}   
catch(IOException ioe)             //Line no A03_Injection: {printl("InputStreamClosed ");                   return ;}                  try{reader.setFeature   ("http://xml.org/sax/features/external-parametric-entity",false); }  catch (SAXException e){println(e .getMessage());   
return;          }}     finally            //Line no A03
!A_Injection: {SystemOutPrintln("Fianlly Block not executed");   return;}                   reader.close();}}};