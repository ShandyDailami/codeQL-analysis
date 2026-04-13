import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;

import java.io.File;
import java.io.IOException;

public class java_34590_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your file
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // create a custom SAX handler to parse the XML
            XMLHandler handler = new XMLHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            // print the parsed data
            for (String data : handler.getData()) {
                System.out.println(data);
            }

        } catch (IOException e) {
            System.out.println("Error reading the XML file.");
        } catch (SAXException e) {
            System.out.println("Error parsing the XML file.");
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {
    private StringBuilder data;

    public java_34590_XMLParser_A03() {
        this.data = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        data.setLength(0); // clear the data
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // no action required here
    }

    public String[] getData() {
        return data.toString().split("\\s+"); // split the data by spaces
    }
}