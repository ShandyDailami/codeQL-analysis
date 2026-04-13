import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class java_26038_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your xml file path

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new ErrorHandlerImpl());

        Document document;
        try {
            document = builder.parse(xmlFile);

            System.out.println("Document parsing finished successfully!");
        } catch (SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        }
    }

    private static class ErrorHandlerImpl extends DefaultHandler {
        @Override
        public void error(SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal SAXParseException: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        }
    }
}