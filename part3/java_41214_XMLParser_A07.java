import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerContent;

import java.io.File;
import java.io.IOException;

public class java_41214_XMLParser_A07 extends DefaultHandler {

    private String desiredElement;
    private String desiredAttribute;

    public java_41214_XMLParser_A07(String desiredElement, String desiredAttribute) {
        this.desiredElement = desiredElement;
        this.desiredAttribute = desiredAttribute;
    }

    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals(desiredElement) && attributes != null) {
            String attributeValue = attributes.getValue(desiredAttribute);
            if (attributeValue != null) {
                System.out.println("Found element: " + qName + " with attribute: " + desiredAttribute + " with value: " + attributeValue);
            } else {
                System.out.println("Found element: " + qName + " without attribute: " + desiredAttribute);
            }
        }
    }

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        String desiredElement = "element";
        String desiredAttribute = "attribute";

        File inputFile = new File(xmlFile);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLParser(desiredElement, desiredAttribute));
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}