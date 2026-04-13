import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_40844_XMLParser_A07 {

    public static void main(String[] args) {
        SAXHandler myHandler = new SAXHandler() {

            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                // do nothing
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                // do nothing
            }

            public void characters(String ch) throws SAXException {
                // do nothing
            }

            public void ignorableWhitespace(String text) throws SAXException {
                // do nothing
            }

            public void error(SAXException e) {
                System.err.println("Parse error: " + e.getMessage());
            }

            public void fatalError(SAXException e) {
                System.err.println("Fatal parse error: " + e.getMessage());
            }

        };

        File xmlFile = new File("input.xml");
        try {
            XMLReader xreader = XMLReaderFactory.createXMLReader(myHandler);
            xreader.setFeature("http://xml.org/sax/features/external-parametrization", false);
            xreader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}