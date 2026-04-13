import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.FileReader;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09979_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Parse XML file using SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXHandler handler = new SAXHandler();
            factory.setValidating(false);
            SAXParser parser = factory.newSAXParser(new FileReader("input.xml"));
            parser.setContentHandler(handler);
            parser.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;

    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = true;
            bAge = true;
        }
        if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println("Name: " + attributes.getValue(""));
        }
        if (bAge && qName.equalsIgnoreCase("age")) {
            System.out.println("Age: " + attributes.getValue(""));
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = false;
            bAge = false;
        }
    }
}