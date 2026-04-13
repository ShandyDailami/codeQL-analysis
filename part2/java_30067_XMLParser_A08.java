import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30067_XMLParser_A08 {

    private static final String FILE_PATH = "a08_integrity_failure.xml";
    private static final String EXPECTED_OPERATION = "ExpectedOperation";

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(FILE_PATH), myHandler);
            System.out.println("Expected operation: " + myHandler.getExpectedOperation());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private String expectedOperation;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals(EXPECTED_OPERATION)) {
                expectedOperation = attributes.getValue("value");
            }
        }

        public String getExpectedOperation() {
            return expectedOperation;
        }
    }
}