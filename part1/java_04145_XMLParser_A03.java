import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_04145_XMLParser_A03 extends DefaultHandler {
    
    public void startDocument() {
        System.out.println("Start document");
    }
    
    public void endDocument() {
        System.out.println("End document");
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
    }
    
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }
    
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        System.out.println("Characters: " + content);
    }
    
    public void error(SAXException e) {
        System.out.println("SAX Exception: " + e.getMessage());
    }
    
    public void fatalError(SAXException e) {
        System.out.println("Fatal SAX Exception: " + e.getMessage());
    }
    
    public void warning(SAXWarning e) {
        System.out.println("SAX Warning: " + e.getMessage());
    }
}

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MySAXHandler());

        InputSource source = new InputSource();
        source.setSystemId("file:/test.xml");
        source.setByteStream(new FileInputStream("test.xml"));

        parser.parse(source, new SAXHandler());
    }
}