import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class java_32850_XMLParser_A08 {

    public static void parse(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXReader();

            // create a SAXSource from the XML data
            SAXSource source = new SAXSource(new StringReader(xmlData), new DefaultHandler());

            // parse the SAXSource
            reader.parse(source, new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }

                @Override
                public void startPrefixMapping(String prefix, String uri) throws SAXException {
                    System.out.println("Start prefix mapping: " + prefix + ", " + uri);
                }

                @Override
                public void endPrefixMapping(String prefix) throws SAXException {
                    System.out.println("End prefix mapping: " + prefix);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Sample XML data
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<document>\n" +
                "    <title>Sample XML</title>\n" +
                "    <content>This is a sample XML document.</content>\n" +
                "</document>";

        parse(xmlData);
    }
}