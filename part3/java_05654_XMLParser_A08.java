import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_05654_XMLParser_A08 {

    public static void main(String[] args) {
        // Define the file we want to parse
        File xmlFile = new File("src/main/resources/example.xml");

        // Create a SAX parser
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // Create a handler for the XML file
        XMLHandler handler = new XMLHandler();
        reader.setContentHandler(handler);

        // Parse the XML file
        try {
            reader.parse(xmlFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // Print the value of the specific element
        System.out.println("Value of the 'name' element: " + handler.getName());
    }

}

class XMLHandler implements org.xml.sax.helpers.DefaultHandler {

    private String name;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            this.name = attributes.getValue("type");
        }
    }

    public String getName() {
        return name;
    }

}