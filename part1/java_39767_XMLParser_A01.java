import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_39767_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        // create a SAX parser
        XMLReader parser = null;
        try {
            parser = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // set the content handler
        parser.setContentHandler(new XMLContentHandler());

        // parse the xml file
        try {
            parser.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        }
    }
}