import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31178_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml"; // Specify your xml file path

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private boolean tagName = false;
    private boolean tagContent = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("name") || qName.equalsIgnoreCase("password")) {
            tagName = true;
            tagContent = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (tagName) {
            String content = new String(ch, start, length);
            System.out.println(content);
            tagName = false;
            tagContent = true;
        }
    }
}