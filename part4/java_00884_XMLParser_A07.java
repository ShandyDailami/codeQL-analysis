import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLEventHandler;

public class java_00884_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserHandler handler = new SAARParserHandler();
        XMLParser parser = new SAXParser(handler);
        try {
            parser.parse("src/main/resources/data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAARParserHandler extends DefaultHandler {
    private boolean authFailure = false;
    private StringBuffer buffer = new StringBuffer();
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        buffer.setLength(0);
        if(qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("authFailure")) {
            if(authFailure) {
                // Handle authFailure here
                System.out.println("Auth Failure detected: " + buffer.toString());
            }
        }
    }
}