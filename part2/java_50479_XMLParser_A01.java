import org.xml.sax.*;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
public class java_50479_XMLParser_A01 { 
    public static void main(String[] args) throws Exception{  
        SAXParserFactory factory = SAXParserFactory.newInstance();    
            try {          
                SAXParser saxparser=factory.newSAXParser(true);                 
         // File to parse         
                 saxparser.parse("sample_filelocation", new MyHandler());  
             } catch (PreparedStatementException e) { 
               System.out.println ("You have broken access control on your Prepared Statement, this is a security sensitive operation and you are not allowed to execute it.");     
          // You can use any other method or exception handling here for the same  
            }    
        catch (Exception e) { 
           System.out.println ("Error parsing the XML file: " +e);   
         // Again, this part is responsible only to handle exceptions and doesn't involve security sensitive operations      
          }     
}             
//SAX Handler class  
class MyHandler implements SAXHandler {    
public void startDocument() throws SAXException {}          
  public void endDocument()    throws SAXException{}            
        // This method will be called for each element starting with "<name>"     
         @Override      
          public boolean handleStartElement(String uri, String localName,    
            String qName, Attributes attributes)  
                throws SAXException {           System.out.println("element:  " +qName); return true; }             // This method will be called for each element ending with "/>"       @Override public boolean handleEndElement(String uri,    
          String localName,    String qName)throws   SAXException{System.out.print ("end of ");           System. out .println (qname); return true;}             // This method will be called for each character     `@ Override  public boolean handleCharacterData(String text){    
          systemOutPrintln("character data: " +text );return false; }    };