import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_37633_XMLParser_A03 extends DefaultHandler {
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.append("<");
        data.append(qName);

        // Add attributes if any
        for (int i = 0; i < attributes.getLength(); i++) {
            data.append(" ");
            data.append(attributes.getQName(i));
            data.append("=\"");
            data.append(attributes.getValue(i));
            data.append("\"");
        }

        data.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        data.append("</");
        data.append(qName);
        data.append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        // Create a SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            // Create a SAXParser
            SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());

            // Parse the XML file
            parser.parse(xmlFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}