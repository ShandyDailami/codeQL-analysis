import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.BasicEntityResolver;

import java.io.File;
import java.io.IOException;

public class java_33484_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("invalid_file.xml");
        BasicEntityResolver resolver = new BasicEntityResolver();

        XMLReader reader = null;
        try {
            // Create a new XMLReader
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(resolver);

            // Add a ContentHandler to the XMLReader
            reader.setContentHandler(new XMLErrorHandler());

            // Parse the XML file
            reader.parse(xmlFile);
        } catch (SAXException e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the XML file: " + e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}

class XMLErrorHandler implements org.xml.sax.ContentHandler {
    @Override
    public void startDocument() {
        System.out.println("Starting document");
    }

    @Override
    public void endDocument() {
        System.out.println("Ending document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Starting element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("Ending element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Reading characters: " + new String(ch, start, length));
    }
}