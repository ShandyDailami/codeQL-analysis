import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_00954_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the SAX parser
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a new instance of the event handler
            MyHandler handler = new MyHandler();

            // Set the event handler for the parser
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(new File("path_to_your_xml_file.xml"));

            // Output the parsed information
            System.out.println(handler.getInfo());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private String info;

    public String getInfo() {
        return info;
    }

    @Override
    public void startDocument() throws SAXException {
        info = "";
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            info += "Person: ";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            info += "\n";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            info += new String(ch, start, length);
        }
    }
}