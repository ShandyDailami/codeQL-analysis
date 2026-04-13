import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_22742_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFilePath = "authFailure.xml"; // Replace with your xml file path
        parseXMLFile(xmlFilePath);
    }

    private static void parseXMLFile(String xmlFilePath) {
        SAXReader reader = new SAXReader();
        XMLHandler handler = new XMLHandler();
        File xmlFile = new File(xmlFilePath);

        try {
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        }
    }
}

class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start Prefix Mapping: " + prefix + ", URI: " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) {
        System.out.println("End Prefix Mapping: " + prefix);
    }
}