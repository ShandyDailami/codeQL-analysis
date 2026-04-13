import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;
import org.xml.sax.helpers.XMLReaderFactoryImpl;

import java.io.File;
import java.io.IOException;

public class java_20621_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            String xmlFile = "path_to_your_xml_file.xml";  // replace with your xml file path
            File file = new File(xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // create a custom handler
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bAuthFailure = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthFailure) {
            // Do something when "AuthFailure" element is found and it's not the end of the element.
            // For example, print the text inside the element.
            String str = new String(ch, start, length);
            System.out.println(str);
        }
    }
}