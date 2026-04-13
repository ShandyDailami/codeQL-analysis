import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_29495_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            File xmlFile = new File("input.xml"); // replace with your xml file
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xmlFile, saxHandler);

            System.out.println("Element Name: " + saxHandler.getElementName());
            System.out.println("Element Attribute: " + saxHandler.getAttribute());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements javax.xml.parsers.SAXHandler {
    private String elementName;
    private String attribute;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        this.elementName = qName;
        this.attribute = attributesToString(attributes);
    }

    private String attributesToString(org.xml.sax.Attributes attributes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            stringBuilder.append(attributes.getQName(i));
            stringBuilder.append("='");
            stringBuilder.append(attributes.getValue(i));
            if (i < attributes.getLength() - 1) {
                stringBuilder.append("' ");
            }
        }
        return stringBuilder.toString();
    }

    public String getElementName() {
        return elementName;
    }

    public String getAttribute() {
        return attribute;
    }
}