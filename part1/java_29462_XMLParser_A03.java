import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_29462_XMLParser_A03 extends DefaultHandler {
    private static final String XML_FILE = "src/main/resources/sample.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE);
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(xmlFile, new XmlParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("element".equals(qName)) {
            String securityInjection = attributes.getValue("name");
            System.out.println("Found security injection in element: " + securityInjection);
        }
    }
}