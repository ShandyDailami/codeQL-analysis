import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29628_XMLParser_A07 extends DefaultHandler {
    // Define a boolean to indicate if an error has occurred
    private boolean authFailure = false;

    // Define a string to hold the error message
    private StringBuilder errorMessage = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // Check if the element is related to auth failure
        if (qName.equalsIgnoreCase("A07_AuthFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Check if the element is related to auth failure
        if (qName.equalsIgnoreCase("A07_AuthFailure")) {
            authFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Check if auth failure is currently active and add the characters to the error message
        if (authFailure) {
            errorMessage.append(new String(ch, start, length));
        }
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        // Add the error message to the error message
        errorMessage.append(e.getMessage());
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        // Add the error message to the error message
        errorMessage.append(e.getMessage());
    }

    public String getErrorMessage() {
        return errorMessage.toString();
    }
}