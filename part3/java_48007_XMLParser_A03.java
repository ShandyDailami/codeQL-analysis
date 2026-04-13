import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_48007_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "C:\\Users\\UserName\\Documents\\samplefile"; //Replace with your file path and name (must be .xml format), or you can use any valid XML document from internet for testing purpose. 
        
       try {   
            ParserFactory.setDefaultProps("org.xml.sax.driver", "false");  
             SAXParser saxParser = SAXParserFactory.newInstance().createSAXParser();    
              MyContentHandler myContentHandler= new MyContentHandler();  //Create your own Handler   
              
            /* Passing the file path and filename to parse with */     
                saxParser.parse(xmlFile,myContentHandler);  
        } catch (Exception e) {     System.out.println("Parsing failed");                   return;  }} ;           public class MyContentHandler extends DefaultHandler    //Create your own Handler         implements SAXHandler     
{       @Override          /* Start element */            
public void startElement(String uri, String localName ,String qName, Attributes attributes) throws SAXException {   System.out.println("Start Element: "+qName); }  //Printing XML tag name on console     try      atempts to access the file or any sensitive operation       
         @Override          /*End element*/             public void endElement(String uri, String localName ,String qName) throws SAXException { System.out.println(" End Element: "+qName); }} //Printing XML tag name on console  for security purpose not to access file or any sensitive operation