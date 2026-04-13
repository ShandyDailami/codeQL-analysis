import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_06170_XMLParser_A08 {

    // Create a default handler
    private static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            // Do nothing
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // Do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // Do nothing
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public static void parseXML(String xmlFilePath) {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.setErrorHandler(new MyHandler());
            reader.parse(new File(xmlFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        parseXML(xmlFilePath);
    }
}