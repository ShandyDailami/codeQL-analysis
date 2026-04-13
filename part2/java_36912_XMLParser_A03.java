import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_36912_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml");
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
            System.out.println("Extracted information: " + handler.getInfo());
        } catch (IOException e) {
            System.out.println("Error occurred while reading the XML file.");
        } catch (SAXException e) {
            System.out.println("Error occurred while parsing the XML file.");
        }
    }
}

class SAXHandler extends DefaultHandler {
    private String info;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("element")) {
            info = attributes.getValue("attribute");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // No operation for endElement
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // No operation for characters
    }

    public String getInfo() {
        return info;
    }
}