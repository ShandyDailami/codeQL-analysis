import java.io.File;
import java.security.InvalidParameterException;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_05846_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the parser
            SAXParserFactory spf = SAXParserFactory.newInstance();

            // Create a new parser
            SAXParser sp = spf.newSAXParser(null);

            // Create a new builder for the document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Get the first and second child element
            Iterator<Element> iterator = root.getElementsByTagName("child1").item(0).getElementsByTagName("child2").item(0).getChildNodes();

            while (iterator.hasNext()) {
                Element element = iterator.nextElement();
                System.out.println("Child Element: " + element.getNodeName());
            }

            // Create a new instance of SAXParser
            SAXParser saxParser = spf.newSAXParser(null);

            // Parse the same XML file using SAX
            saxParser.parse(new File("sample.xml"), new XMLHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define a SAXHandler to handle XML tags
class XMLHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}