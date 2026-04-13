import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_15038_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            // No operation.
        }
    }

    public static void main(String[] args) {
        try {
            String xmlFile = "/path/to/your/file.xml";
            InputStream input = new FileInputStream(xmlFile);
            XMLReader parser = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            parser.setContentHandler(handler);
            parser.parse(new InputSource(input));
            System.out.println("Parsing completed successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX exception: " + e.getMessage());
        }
    }
}