import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XSIStreamReader;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class java_18710_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            InputStream xmlInputStream = Main.class.getResourceAsStream("/authFailure.xml");
            if (xmlInputStream == null) {
                System.out.println("Failed to load XML file!");
                return;
            }
            XMLParser(xmlInputStream);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error while parsing the XML file: " + e.getMessage());
        }
    }

    public static void XMLParser(InputStream inputStream) throws ParserConfigurationException, SAXException {
        org.xml.sax.XMLReader reader = org.xml.sax.SAXReader.newInstance();
        AuthFailureHandler handler = new AuthFailureHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(inputStream));
    }

    static class AuthFailureHandler implements org.xml.sax.ContentHandler {

        @Override
        public void startDocument() {}

        @Override
        public void endDocument() {}

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {}

        @Override
        public void endElement(String uri, String localName, String qName) {}

        @Override
        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            // handle security sensitive operations related to A07_AuthFailure
        }

        @Override
        public void error(SAXException e) {}

        @Override
        public void fatalError(SAXException e) {}

        @Override
        public void warning(SAXException e) {}
    }
}