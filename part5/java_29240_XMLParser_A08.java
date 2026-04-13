import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29240_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        MyHandler handler = new MyHandler();
        parser.parse(MyXMLParser.class.getResourceAsStream("/example.xml"), handler);
    }

    static class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private String tagValue = null;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bTag = true;
            tagValue = "";
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
       
            if(localName.equalsIgnoreCase("password")){
                printPassword(tagValue);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                tagValue = new String(ch, start, length);
            }
        }

        private void printPassword(String password){
            // Security-sensitive operations: use password here, e.g., hashing
            System.out.println("Processing password: " + password);
        }
    }
}