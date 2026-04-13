import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_31133_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        SAXParser saxParser = new SAXParser();
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParser);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}

class SAXParser implements org.xml.sax.ContentHandler {

    private boolean bElement = false;
    private String elementData = null;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        bElement = true;
        elementData = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;

        // You can use elementData here for security-sensitive operations related to A08_IntegrityFailure.
        // For example, you can check if the data is valid or not.

        System.out.println(qName + ": " + elementData);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            elementData = new String(ch, start, length);
        }
    }

}