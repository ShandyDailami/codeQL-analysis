import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_36777_XMLParser_A07 {

    private static class AuthFailureHandler implements org.xml.sax.helpers.DefaultHandler {

        private List<String> errorMessages = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
            // Check for A07_AuthFailure error.
            if (qName.equals("AuthFailure")) {
                // Extract and print the error message.
                String errorMessage = attributes.getValue("message");
                errorMessages.add(errorMessage);
                System.out.println("A07_AuthFailure error: " + errorMessage);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Check for A07_AuthFailure error.
            if (qName.equals("AuthFailure")) {
                // Print the error messages.
                for (String errorMessage : errorMessages) {
                    System.out.println("Error message: " + errorMessage);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Create a SAXParserFactory.
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // Create a SAXParser using the factory.
        SAXParser parser = factory.newSAXParser();

        // Create a AuthFailureHandler.
        AuthFailureHandler handler = new AuthFailureHandler();

        // Parse the XML file.
        parser.parse(new URL("http://example.com/authfailure.xml"), handler);
    }
}