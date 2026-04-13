import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_25747_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml";

        try {
            File xmlFile = new File(xmlFilePath);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Failed to parse the XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {

    private boolean isInElement = false;
    private String currentElement = "";

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, org.xml.sax.Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qualifiedName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
        }
    }
}