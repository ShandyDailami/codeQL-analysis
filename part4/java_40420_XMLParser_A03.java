import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40420_XMLParser_A03 {
    public static void parse(String xmlContent) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);
        
        MyHandler handler = new MyHandler();
        parser.parse(xmlContent, handler);
    }
    
    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String currentTag = "";
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentTag = qName;
            
            if ("person".equals(qName)) {
                bName = true;
                bAge = true;
            } else {
                System.out.println("Start Element: " + qName);
            }
        }
        
        @Override
        public java_40420_XMLParser_A03(String uri, String localName, String qName) throws SAXException {
            if ("person".equals(qName)) {
                bName = false;
                bAge = false;
            }
            
            System.out.println("End Element: " + qName);
        }
        
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }
            
            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}