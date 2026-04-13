import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03495_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

        try {
            saxParser.parse(new File("sample.xml"), true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            sb.setLength(0);
            System.out.println("Start Element: " + qName);
            // Add your security-sensitive operations here, for example:
            // String password = attributes.getValue("password");
            // if (password != null && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            //     System.out.println("Password is secure: " + password);
            // }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
            System.out.println("Content: " + sb.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            sb.append(new String(ch, start, length));
        }
    }
}