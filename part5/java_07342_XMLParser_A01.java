import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_07342_XMLParser_A01 {
    public static void parse(String xmlFile) {
        XMLReader xmlReader = null;
        try {
            // Create SAX parser
            xmlReader = SAXParserFactory.newInstance().newSAXParser(true);
            xmlReader.setContentHandler(new XMLErrorHandler());

            // Parse XML
            xmlReader.parse(new InputSource(new FileInputStream(xmlFile)));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close SAX parser
            if (xmlReader != null) {
                xmlReader.setContentHandler(null);
                xmlReader.close();
            }
        }
    }

    // Default handler for SAX events
    private static class XMLErrorHandler extends DefaultHandler {
        @Override
        public void error(SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal SAXException: " + e.getMessage());
        }

        @Override
        public void warning(SAXWarning e) {
            System.out.println("SAXWarning: " + e.getMessage());
        }
    }
}