import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.AuthFailure;
import org.xml.sax.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;

public class java_14702_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            DefaultHandler defaultHandler = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equals("message")) {
                        // This is a security-sensitive operation
                        String message = attributes.getValue("message");
                        // Check if the message contains "AuthFailure"
                        if (message.contains("AuthFailure")) {
                            System.out.println("Security Error: Authentication failed!");
                        }
                    }
                }
            };
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(defaultHandler);
            saxParser.parse("sample.xml", xmlReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}