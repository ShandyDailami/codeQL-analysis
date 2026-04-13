import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_13725_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            String xmlFile = "/path/to/your/xml/file.xml"; // replace with your xml file path
            parseXmlFile(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(String xmlFile) throws Exception {
        File xmlFileToBeOpened = new File(xmlFile);
        InputStream inStream = new FileInputStream(xmlFileToBeOpened);
        Reader xmlFileReader = new InputStreamReader(inStream);

        XMLReader parser = XMLReaderFactory.createXMLReader();

        parser.setContentHandler(new MyContentHandler());

        parser.parse(new InputSource(xmlFileReader));
    }

    private static class MyContentHandler implements org.xml.sax.ContentHandler {
        public void startDocument() {}
        public void endDocument() {}

        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {}
        public void endElement(String uri, String localName, String qName) {}
        public void characters(char[] ch, int start, int length) {
            System.out.println(new String(ch, start, length));
        }
        public void error(org.xml.sax.SAXException e) {}
        public void fatalError(org.xml.sax.SAXException e) {}
        public void warning(org.xml.sax.SAXWarning e) {}
    }
}