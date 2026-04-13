import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_23410_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml"); // replace with your XML file path
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends AbstractReadingHandler {
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
            throws SAXException {
        System.out.println("Start element: " + qName);
        for (int i = 0; i < atts.getLength(); i++) {
            System.out.println("Attribute: " + atts.getQName(i) + " = " + atts.getValue(i));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }
}