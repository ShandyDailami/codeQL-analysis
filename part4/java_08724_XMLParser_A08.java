import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_08724_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file.xml";  // replace with your file path
        parseFile(filePath);
    }

    private static void parseFile(String filePath) {
        try {
            File file = new File(filePath);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlHandler());
            reader.parse(file);
        } catch (IOException e) {
            System.out.println("Error parsing file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error processing XML: " + e.getMessage());
        }
    }

    private static class XmlHandler extends DefaultHandler {
        private boolean integrityFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("operation")) {
                String operation = attributes.getValue("operation");
                if (operation.equals("A08_IntegrityFailure")) {
                    integrityFailure = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("operation")) {
                if (integrityFailure) {
                    System.out.println("Detected A08_IntegrityFailure operation");
                    integrityFailure = false;
                }
            }
        }
    }
}