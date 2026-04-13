import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23494_XMLParser_A07 {

    private static final String XML_FILE_PATH = "src/main/resources/example.xml";  // change this to the path of your XML file

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(new File(XML_FILE_PATH))) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(new File(XML_FILE_PATH));

            System.out.println(saxHandler.getResult());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

        private StringBuilder result = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                throws SAXException {
            // A07_AuthFailure: Secure operation, avoid using hardcoded credentials
            // As it's not possible to verify if XML is secure or not without knowing the source, we assume that it's secure.
            result.append("Start element: ").append(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            result.append("End element: ").append(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            result.append(new String(ch, start, length));
        }

        public StringBuilder getResult() {
            return result;
        }
    }
}