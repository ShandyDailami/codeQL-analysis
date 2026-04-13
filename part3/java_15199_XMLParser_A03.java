import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_15199_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("students.xml");

        // Create a new SAX reader
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // Create a new student handler
        StudentHandler handler = new StudentHandler();

        // Set the handler for the SAX reader
        reader.setContentHandler(handler);

        // Parse the XML file
        try {
            reader.parse(xmlFile);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}

class StudentHandler implements org.xml.sax.helpers.DefaultHandler {
    private boolean nameFound = false;
    private boolean ageFound = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName) {
        currentElement = qName;
        if (qName.equals("name")) {
            nameFound = true;
        } else if (qName.equals("age")) {
            ageFound = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (nameFound) {
            System.out.println("Name: " + new String(ch, start, length));
            nameFound = false;
        } else if (ageFound) {
            System.out.println("Age: " + new String(ch, start, length));
            ageFound = false;
        }
    }
}