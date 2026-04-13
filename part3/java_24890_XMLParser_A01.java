import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_24890_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";
        parseXmlFile(xmlFilePath);
    }

    public static void parseXmlFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setEntityResolver(new MyEntityResolver());
            xmlReader.setValidation(true);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);

            // Start parsing the XML file
            xmlReader.parse(xmlFile);

            // Print out the tags and attributes
            printTagsAndAttributes(xmlReader);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printTagsAndAttributes(XMLReader xmlReader) {
        int type;
        try {
            do {
                type = xmlReader.getEventType();
                switch (type) {
                    case XMLReader.START_ELEMENT:
                        String elementName = xmlReader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLReader.END_ELEMENT:
                        elementName = xmlReader.getLocalName();
                        System.out.println("End element: " + elementName);
                        break;
                    case XMLReader.ATTRIBUTE_SPACE:
                        String attributeName = xmlReader.getAttributePrefix() + ":" + xmlReader.getAttributeLocalName();
                        String attributeValue = xmlReader.getElementText();
                        System.out.println("Attribute: " + attributeName + "=" + attributeValue);
                        break;
                }
            } while (xmlReader.next() != type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}