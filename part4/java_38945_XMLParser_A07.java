import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_38945_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/authfailure.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(myHandler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        private boolean authFailureFound = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            if (qName.equals("authfailure")) {
                authFailureFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals("authfailure")) {
                if (!authFailureFound) {
                    System.out.println("No authfailure tags found!");
                }
                authFailureFound = false;
            }
        }
    }
}