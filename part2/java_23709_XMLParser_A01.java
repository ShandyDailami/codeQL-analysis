import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_23709_XMLParser_A01 extends DefaultHandler {

    private String currentElement;
    private String xmlContent;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        xmlContent += "<" + qName + ">";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        xmlContent += "</" + qName + ">";
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            xmlContent += new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element1>content1</element1><element2>content2</element2></root>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyXMLParser());

        parser.parse(new StringReader(xml));

        System.out.println(xml);
        System.out.println(parser.getErrorHandler().getFormattedMessage(null));
    }
}