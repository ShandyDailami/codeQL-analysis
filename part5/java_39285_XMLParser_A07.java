import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.net.*;

public class java_39285_XMLParser_A07 {

    // DefaultHandler is a SAX handler that does nothing
    private static class MyHandler extends DefaultHandler {

        // Override the startElement method to print the start tag
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
        }

        // Implement other methods to handle start, end, and character events

    }

    public static void main(String[] args) {
        String urlStr = "http://example.com"; // URL of the XML document

        try {
            URL url = new URL(urlStr);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new InputSource(url.openStream()));

            MyHandler handler = new MyHandler();
            sp.parse(new InputSource(url.openStream()), handler);

        } catch (MalformedURLException mue) {
            System.err.println("Invalid URL: " + mue.getMessage());
        } catch (SAXException se) {
            System.err.println("Error parsing the document: " + se.getMessage());
        } catch (ParserConfigurationException pce) {
            System.err.println("Error loading configuration: " + pce.getMessage());
        }
    }
}