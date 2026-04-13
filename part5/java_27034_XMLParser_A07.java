import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_27034_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("legacy.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(xmlFile, myHandler);

            System.out.println("XML file parsed successfully.");
        } catch (Exception e) {
            System.out.println("Error parsing XML file.");
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean authFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            if ("authFailure".equals(qName)) {
                authFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if ("authFailure".equals(qName)) {
                if (authFailure) {
                    System.out.println("Auth Failure detected!");
                } else {
                    System.out.println("No Auth Failure detected.");
                }
                authFailure = false;
            }
        }
    }
}