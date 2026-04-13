import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReader.EntityResolver;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_15963_XMLParser_A03 {

    public static class InjectionHandler extends DefaultHandler {

        private boolean isInTag = false;
        private String currentTag = null;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            isInTag = true;
            currentTag = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            isInTag = false;
            currentTag = null;
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (isInTag) {
                System.out.println("Injection attempt detected in tag: " + currentTag);
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "injection.xml";  // replace with your file path
        EntityResolver resolver = new XMLReaderFactory.EntityResolver() {

            @Override
            public InputSource resolveEntity(String url) throws SAXException, IOException {
                if (url.equals("injection.xml")) {
                    return new InputSource(new StringReader("<entity>" + url + "</entity>"));
                }
                return null;
            }
        };
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setEntityResolver(resolver);
        try {
            reader.setContentHandler(new InjectionHandler());
            reader.parse(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}