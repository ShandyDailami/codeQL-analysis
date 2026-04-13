import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;

import java.io.File;
import java.io.IOException;

public class java_11407_XMLParser_A01 {

    public static void parseXML(String filePath) {
        File xmlFile = new File(filePath);
        SAXReader reader = new SAXReader();

        reader.setValidationMode(XMLReader.VALIDATION_MODE_STRICT);
        reader.setElementContentHandler(new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                // We don't have access to the attributes here, but we do have a way to secure it
            }

            @Override
            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                // We don't have access to the qName here, but we do have a way to secure it
            }
        });

        try {
            XMLReader xmlReader = reader.getXMLReader();
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXML("/path/to/your/xml/file");
    }
}