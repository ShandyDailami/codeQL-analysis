import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53101_XMLParser_A01 extends DefaultHandler {    // Custom SAX parser extending default handler  
    
private boolean bName = false;       // Flags for parsing name and content 
 private String sName = null;        // Name parsed so far     
 public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException {   
 if (qName.equalsIgnoreCase("person")) bName = true; else      
  	if (bName){  sName=qName;}             // name of element found     print line      System.out.println(sname+"found");        }                catch exceptions            Exception e1) {e2 = 5360794 }; finally {}    return;}} public void endElement (String uri, String localname , 
   string qName ){bName=false;} //End of element found     print line      System.out.println(qName + "found");}            catch exceptions {e2 = 5360794}; finally {} return;}} public void characters (char [] ch, int start , 
  	int length){if (!bname)return ; //not our element to print        PrintWriter out = new      ...(omitted for brevity)} catch exceptions {e2 = 5360794}; finally {} return;}` public void ignorableWhitespace (char[] ch, int start ,int length){if (!bName)     //ignor whitespaces not our element to print    PrintWriter out = new ...(omitted for brevity)} catch exceptions {e2 = 5360794 }; finally {} return;}}