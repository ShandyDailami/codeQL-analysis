import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_18142_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<root><element>secure data</element></root>";

        // Create a SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // Create a SAXParser using the factory
        try {
            SAXParser saxParser = factory.newSAXParser(null);

            // Create a SAXSource
            SAXSource source = new SAXSource(new StringReader(xml), false);

            // Create a XMLReader
            XMLReader xmlReader = saxParser.getXMLReader();

            // Create a default handler
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName,
                                       org.xml.sax.Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);

                    // Check for integrity failures
                    if (qName.equals("element")) {
                        // Accessing content of the element
                        String content = attributes.getValue("attribute");
                        if (content == null || content.length() == 0) {
                            System.out.println("IntegrityFailure: Attribute 'attribute' is missing.");
                        }
                    }
                }
            };

            // Parse the XML
            xmlReader.setContentHandler(handler);
            xmlReader.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}