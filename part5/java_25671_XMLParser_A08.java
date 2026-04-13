import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_25671_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCountry = false;
    private String name = null;
    private int age = 0;
    private String country = null;
    
    public java_25671_XMLParser_A08() {
        super();
    }

    public void startDocument() throws SAXException {
        System.out.println("Parsing Started");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // reset all flags
            bName = false;
            bAge = false;
            bCountry = false;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Country: " + country);
            System.out.println("----------");
        }
    }

    public void endDocument() {
        System.out.println("Parsing Ended");
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        String inputFile = "example.xml";
        File file = new File(inputFile);
        SAXReader reader = new SAXReader();

        try {
            XMLReader xmlReader = reader.getXMLReader(new MyXMLParser());
            xmlReader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}