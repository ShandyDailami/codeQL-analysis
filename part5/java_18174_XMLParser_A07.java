import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_18174_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            File xmlFile = new File("path/to/your/file.xml"); // replace with your XML file path
            saxParser.parse(xmlFile, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean isUser = false;
        private boolean isPassword = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                isUser = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                isUser = false;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUser) {
                // handle user data securely, e.g., store it in a secure environment variable or database
                System.out.println("User data: " + new String(ch, start, length));
            } else if (isPassword) {
                // handle password data securely, e.g., store it in a secure environment variable or database
                System.out.println("Password data: " + new String(ch, start, length));
            }
        }
    }
}