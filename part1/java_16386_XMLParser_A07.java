import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_16386_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
            
            System.out.println("XML Parsing Completed Successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.ContentHandler {
    @Override
    public void startDocument() {}
    
    @Override
    public void endDocument() {}
    
    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {}
    
    @Override
    public void endElement(String uri, String localName, String qName) {}
    
    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }
}