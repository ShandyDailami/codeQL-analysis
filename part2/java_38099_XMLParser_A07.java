import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;

public class java_38099_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            String url = "yourfile.xml"; // replace with your xml file path
            File file = new File(url);
            InputStream inputStream = new FileInputStream(file);

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());

            reader.parse(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends MyContentHandlerBase {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                org.xml.sax.Attributes atts) throws SAXException {
            System.out.print("Start Element : " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End Element : " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (length > 0) {
                System.out.println("Characters : " + new String(ch, start, length));
            }
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error : " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error : " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning : " + e.getMessage());
        }

    }

    static class MyContentHandlerBase implements org.xml.sax.ContentHandler {

    }

}