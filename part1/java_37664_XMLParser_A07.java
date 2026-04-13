import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_37664_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            SAXHandler handler = new SAXHandler();

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        }
        if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}