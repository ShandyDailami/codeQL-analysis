import java.io.File;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXHandler;

public class java_16773_XMLParser_A07 {

    private class MyHandler extends SAXHandler {
        private boolean authFailed = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("auth")) {
                String auth = attributes.getValue("fail");
                if ("fail".equals(auth)) {
                    authFailed = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // do nothing
        }
    }

    public boolean parseFile(String fileName) {
        File file = new File(fileName);
        SAXReader reader = XMLReaderFactory.createSAXReader();
        reader.setContentHandler(new MyHandler());
        try {
            reader.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return !MyHandler.authFailed;
    }
}