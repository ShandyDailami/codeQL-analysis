import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_14271_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);

            // Create a handler
            MyHandler handler = new MyHandler();

            // Parse the XML file
            saxParser.parse("src/main/resources/authFailure.xml", handler);

            // Print the results
            System.out.println("Failed attempts: " + handler.getFailedAttempts());
            System.out.println("Successful attempts: " + handler.getSuccessfulAttempts());

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private int failedAttempts = 0;
    private int successfulAttempts = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("AuthFailure")) {
            // Security-sensitive operation here.
            // For example, validate login credentials, check user's permissions, etc.
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("AuthFailure")) {
            // Mark the attempt as successful or failed based on the result.
            failedAttempts++;
        }
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public int getSuccessfulAttempts() {
        return successfulAttempts;
    }
}