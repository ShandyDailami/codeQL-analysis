import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_39202_XMLParser_A03 extends DefaultHandler {

    private boolean isName = false;
    private boolean isValue = false;
    private String name = null;
    private String value = null;

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        try {
            parser.parse(xmlFile, new XmlParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
            name = "";
        } else if (qName.equalsIgnoreCase("value")) {
            isValue = true;
            value = "";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isName && name != null && name.length() > 0) {
            // Check for injection vulnerability:
            if (name.contains("<script>")) {
                System.out.println("Security warning: Potential injection vulnerability detected in the 'name' element.");
            }
            isName = false;
            name = null;
        } else if (isValue && value != null && value.length() > 0) {
            // Check for injection vulnerability:
            if (value.contains("<script>")) {
                System.out.println("Security warning: Potential injection vulnerability detected in the 'value' element.");
            }
            isValue = false;
            value = null;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        if (isName) {
            name = name + new String(chars, start, length);
        } else if (isValue) {
            value = value + new String(chars, start, length);
        }
    }
}