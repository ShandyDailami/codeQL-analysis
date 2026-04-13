import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_29331_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            parseXML(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(File xmlFile) throws Exception {
        InputStream inputStream = new FileInputStream(xmlFile);
        InputSource inputSource = new InputSource(inputStream);
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        // No SAX parser, we only need to read the XML
        xmlReader.setContentHandler(new XMLErrorHandler());

        // Start reading the XML
        xmlReader.parse(inputSource);
    }

    // Handling parsing errors
    private static class XMLErrorHandler implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void warning(SAXException e) throws SAXException {
            // Ignore warnings
        }

        @Override
        public void error(SAXException e) throws SAXException {
            // Log or handle errors
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            // Log or handle fatal errors
        }
    }
}