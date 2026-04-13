import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_07097_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";  // replace with your actual xml file path
        parseXMLFile(xmlFilePath);
    }

    public static void parseXMLFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    boolean firstName = true;
    boolean thirdName = false;
    String currentElement;

    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String uri, String localName, String qName) {
        currentElement = qName;
        if (currentElement.equals("name")) firstName = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("name")) {
            if (firstName) {
                System.out.println("First name: ");
                firstName = false;
            } else if (thirdName) {
                System.out.println("Third name: ");
                thirdName = false;
            }
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {}
}