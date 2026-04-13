import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_26193_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        private boolean bUsername = false;
        private boolean bPassword = false;
        private String username = null;
        private String password = null;

        @Override
        public void startElement(String uri, String localName, String qName,
                                                 Attrs atts) throws SAXException {
            if ("username".equals(localName)) {
                bUsername = true;
            } else if ("password".equals(localName)) {
                bPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if ("username".equals(localName)) {
                bUsername = false;
            } else if ("password".equals(localName)) {
                bPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bUsername) {
                username = new String(ch, start, length);
            } else if (bPassword) {
                password = new String(ch, start, length);
            }
        }
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(new File("sample.xml"));
            System.out.println("Username: " + reader.getCharacterEncoding() + reader.getErrorLog().getLastError());
            System.out.println("Password: " + reader.getCharacterEncoding() + reader.getErrorLog().getLastError());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}