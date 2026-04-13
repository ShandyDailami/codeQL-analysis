import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_41545_XMLParser_A08 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String url = "http://www.example.com/books.xml"; // replace with your URL
        parse(url);
    }

    public static void parse(String url) throws ParserConfigurationException, SAXException {
        // Step 1: Setup the XML Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // enable validation for integrity check
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Load and Validate the XML Document
        Document document = builder.parse(new InputSource(new StringReader(url)));

        // Step 3: Handle the parsed XML document
        MyHandler handler = new MyHandler();
        document.getDomConfig().setValidating(true); // enable validation for integrity check
        document.getDomConfig().setErrorHandler(handler);
        document.getDomConfig().setNamespaceAware(true);

        XMLReader reader = document.getXmlReader();
        reader.setValidation(true); // enable validation for integrity check

        // Replace 'reader.parse' with 'reader.event()' if you need to wait for all events
        reader.parse(new InputSource(new StringReader(url)));
    }

    static class MyHandler extends DefaultHandler {
        public void error(SAXParseException e) throws SAXException {
            // check integrity here
            // if the integrity is broken, throw a SAXException
            throw new SAXException("Integrity failure");
        }
    }
}