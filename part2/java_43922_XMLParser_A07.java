import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_43922_XMLParser_A07 {  
  public static void main(String[] args) throws ParserConfigurationException, SAXException{   
     // Create a new XMLReader object with DOM parser factory for parsing an HTML document     
       XmlParserFactory xmlFact = XmlParserFactory.newInstance();          
        URL url= Main.class.getResource("sample104-3a89b67d_AuthFailureExample/authfailuretestfile");   // provide the file path here  (You need to add your .xml into project resources)         
       XMLReader xmlr = xmlFact.newSAXXMLReader(url);     
         try {          
             MyHandler myhandler= new MyHandler();             
               int events = 0;               
                 while ((events = xmlr.getFeature(org.apache.xml.serialize.OutputFormat.ITEM_EVENTS)) != 0)  // parse until complete      
                    for (int i = 0; i < events ;i++){            
                         switch (xmlr.getCurrentEvent()) {              case HANDLER_START:          xmlr.next();break;}        default :   break;}}catch(Exception ex ){ex.printStackTrace();}                catch (ParserConfigurationException pce)  // Avoid this line if you are not handling external configurations correctly    
            }         finally {           try {if (!xmlFact .getNamespaceSupport() && xmlr instanceof InputSource){InputSource is = ((InputSource )(xmlr));   /* disable namespace support */is.setCharacterStream(new StringReader("<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>\n"+ (char) 23 + "\t"));}}catch{ex.printStackTrace();}
       }}            catch { ex . print Stack Trace() }   // handle any exception in the try block and display it here for debugging purposes         });}}}