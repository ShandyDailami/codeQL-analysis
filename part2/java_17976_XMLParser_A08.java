import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_17976_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // Your XML file

        File inputFile = new File(xmlFile);

        if (!inputFile.exists()) {
            System.err.println("XML file not found!");
            System.exit(0);
        }

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            XmlHandler handler = new XmlHandler();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);

            reader.parse(inputFile);

        } catch (SAXParseException e) {
            System.err.println("Parsing error: " + e.getMessage());
            System.exit(0);

        } catch (IOException e) {
            System.err.println("Reading error: " + e.getMessage());
            System.exit(0);

        } catch (SAXException e) {
            System.err.println("SAX parsing error: " + e.getMessage());
            System.exit(0);
        }
    }

}

class XmlHandler implements org.xml.sax.helpers.DefaultHandler {

    boolean bFoundElementName = false;
    boolean bFoundElementContent = false;
    String currentElementName = "";
    String currentElementContent = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        bFoundElementName = true;
        bFoundElementContent = false;
        currentElementName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bFoundElementName = false;
        bFoundElementContent = true;
        currentElementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bFoundElementContent) {
            currentElementContent += new String(ch, start, length);
        }
    }

}